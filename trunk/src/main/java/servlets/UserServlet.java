package servlets;

import DAO.UserDAO;
import model.User;
import services.Emailer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class UserServlet extends HttpServlet {
    UserDAO dao;
    private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
        dao = new UserDAO();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        switch (ActionName.valueOf(request.getParameter("action"))) {

            case CREATE_USER:
                createUser(request, response);
                 response.sendRedirect("index.jsp");
                break;
            case MODIFY_USER:
                modifyUser(request, response);
                 response.sendRedirect("index.jsp");
                break;
            case ADD_FRIEND:
                addFriend(request,response);


        }


    }

    private void modifyUser(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0);
        user.setEmail(request.getParameter("mail"));
        user.setPassword(request.getParameter("pass"));

        UserDAO.persist(user);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        User user = new User(name, pass, request.getParameter("mail"));
        dao.persist(user);
        Emailer mailer = new Emailer();
        String message = "Hola "+name+" ! El staff te da la bienvenida a CoffeeBreak! Username: "+name+" /n Password: "+pass;
        mailer.sendMail(request.getParameter("mail"),"Bienvenido a CoffeeBreak",message);


    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response){
         User user = (User) UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0);
         User friend = (User) UserDAO.retrieveUserbyNickName(request.getParameter("email")).get(0);

        String message = user.getNickName()+"<p> te ha enviado una invitacion a COFFEEBREAK.</p>" +
                "<p>Ingresa a www.coffeebreakapp.com para registrarte!</p>";


        if(friend!=null){
           user.getFriends().add(friend);
           friend.getFriends().add(user);
           dao.persist(user);
            dao.persist(friend);
        } else{
           Emailer mailer = new Emailer();
            mailer.sendMail("email","Invitacion a COFFEEBREAK",message);
        }

    }
}