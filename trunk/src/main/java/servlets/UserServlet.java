package servlets;

import DAO.UserDAO;
import enums.*;
import enums.Error;
import model.User;
import services.Emailer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

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
                response.sendRedirect("index.jsp");


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
        String message = "Welcome "+name+" ! The CoffeeBreak staff welcomes you to CoffeeBreak! Username: "+name+" Password: "+pass;
        mailer.sendMail(request.getParameter("mail"),"Welcome to CoffeeBreak",message);


    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response){
         User user = (User) UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0);
         List<User> friendList =  UserDAO.retrieveUserbyEmail(request.getParameter("email"));


        String message = user.getNickName()+" has sent you an invitation to COFFEEBREAK! Go to www.coffeebreakapp.com.ar to register";


        if(friendList.size()!=0){
           User friend = friendList.get(0);
           user.getFriends().add(friend);
           friend.getFriends().add(user);
           dao.persist(user);
           dao.persist(friend);
        } else{
           Emailer mailer = new Emailer();
           mailer.sendMail(request.getParameter("email"),"COFFEEBREAK invitation",message);

        }




    }
}