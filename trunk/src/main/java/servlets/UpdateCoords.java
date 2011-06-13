package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 6/12/11
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateCoords extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String latitude= request.getParameter("latitude");
          String longitud= request.getParameter("longitud");
        //TODO poner esto en el usuario
      }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

}
