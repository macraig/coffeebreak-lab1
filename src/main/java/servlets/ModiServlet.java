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
 * Time: 2:47 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ModiServlet")
public class ModiServlet extends HttpServlet {
    User user;
    UserDAO dao = new UserDAO();

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);


       }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
