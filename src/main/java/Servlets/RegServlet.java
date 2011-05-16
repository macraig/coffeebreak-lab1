package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

/**
* Servlet implementation class MyServlet
*/
@WebServlet("/MyServlet")
public class RegServlet extends HttpServlet {
    UserDAO dao;
       private static final long serialVersionUID = 1L;
       
       public RegServlet() {
       super();
        dao = new UserDAO();
   }


       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*   response.setContentType("text/html");
          PrintWriter write = response.getWriter();
          write.println("<html> <body> <h1> AAAAAAAAAAA </h1> </body> </html>"); */
       }


       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           User user = new User(request.getParameter("name"), request.getParameter("pass"), request.getParameter("mail"));
           dao.persist(user);



               response.setContentType("text/html");
               PrintWriter write = response.getWriter();
               write.println("<html> <body> <h1> User creado con exito </h1> </body> </html>");
               
       }

}