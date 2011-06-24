package servlets;

import DAO.UserDAO;
import enums.ActionName;
import model.Invitation;
import model.Place;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
                showFavourites(request, response);
                break;
            case SHOW_INVITATIONS:
                showInvitations(request, response);
                break;
            case CHECK_ADMIN:
                checkAdmin(request, response);
                break;

        }


    }

    private void checkAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (UserDAO.retrieveUserbyNickName(request.getRemoteUser()).isAdmin()) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void showFavourites(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Set<Place> placeSet = UserDAO.retrieveUserbyNickName(request.getRemoteUser()).getFavouritePlaces();
        ArrayList<Place> arrayList = new ArrayList<Place>(placeSet);
        request.setAttribute("places", arrayList);
        request.getRequestDispatcher("places.jsp").forward(request, response);

    }

    private void showInvitations(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Set<Invitation> invitations = UserDAO.retrieveUserbyNickName(request.getRemoteUser()).getInvitations();
        ArrayList<Invitation> arrayList = new ArrayList<Invitation>(invitations);
        request.setAttribute("invitations", arrayList);
        request.getRequestDispatcher("invitations.jsp").forward(request, response);

    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Set<User> b = UserDAO.retrieveUserbyNickName(request.getRemoteUser()).getFriends();
        ArrayList<User> a = new ArrayList<User>(b);
        Collections.sort(a);
        request.setAttribute("friends", a);
        request.getRequestDispatcher("friends.jsp").forward(request, response);
    }

    private void modifyUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser());
        request.setAttribute("user", user);
        request.getRequestDispatcher("mod.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
