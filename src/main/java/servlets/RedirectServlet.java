package servlets;

import DAO.UserDAO;
import enums.ActionName;
import model.Place;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 5/24/11
 * Time: 2:47 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "RedirectServlet")
public class RedirectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        switch (ActionName.valueOf(request.getParameter("action"))) {

            case MODIFY_USER:
                modifyUser(request, response);
                break;
            case ADD_FRIEND:
                addFriend(request, response);
                break;
            case SHOW_FAVOURITES:
                showFavourites(request,response);
                break;
            case CHECK_ADMIN:
                checkAdmin(request,response);
                break;

        }


    }

    private void checkAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (((User)UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0)).isAdmin()){
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    private void showFavourites(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Set<Place> placeSet = ((User) UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0)).getFavouritePlaces();
        ArrayList<Place> arrayList = new ArrayList<Place> (placeSet);
        request.setAttribute("places", arrayList);
        request.getRequestDispatcher("places.jsp").forward(request, response);

    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Set<User> b = ((User) UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0)).getFriends();
        ArrayList<User> a = new ArrayList<User> (b);
        request.setAttribute("friends", a);
        request.getRequestDispatcher("friends.jsp").forward(request, response);
    }

    private void modifyUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser()).get(0);
        request.setAttribute("user", user);
        request.getRequestDispatcher("mod.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
