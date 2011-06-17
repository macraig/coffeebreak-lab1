package servlets;

import DAO.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 5/24/11
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ModServlet")
public class ModServlet extends HttpServlet {


 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser());
     user.setEmail(request.getParameter("mail"));
     user.setPassword(request.getParameter("pass"));

     UserDAO.persist(user);


       }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);

    }
}
