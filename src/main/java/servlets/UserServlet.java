package servlets;

import DAO.InviteDAO;
import DAO.LocationDAO;
import DAO.PlaceDAO;
import DAO.UserDAO;
import enums.ActionName;
import model.Invitation;
import model.Location;
import model.Place;
import model.User;
import net.sf.json.JSONArray;
import services.Emailer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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
                addFriend(request, response);
                response.sendRedirect("/redirect.do?action=ADD_FRIEND");
                break;
            case UPDATE_LOCATION:
                updateLocation(request, response);
                break;
            case PLACE_FRIENDS:
                sendFriendsJson(request, response);
                break;
            case ADD_FAVOURITE:
                addFavouritePlace(request, response);
                response.sendRedirect("index.jsp");
                break;
            case DELETE_USER:
                deleteUser(request, response);
                request.setAttribute("users", UserDAO.retrieveUserList());
                request.getRequestDispatcher("allUsers.jsp").forward(request, response);
                break;
            case RESTORE_USER:
                restoreUser(request, response);
                request.setAttribute("users", UserDAO.retrieveUserList());
                request.getRequestDispatcher("allUsers.jsp").forward(request, response);
                break;
            case LOCATE_FRIEND:
                locateFriend(request, response);
                break;
            case MAKE_ADMIN:
                makeAdmin(request, response);
                request.setAttribute("users", UserDAO.retrieveUserList());
                request.getRequestDispatcher("allUsers.jsp").forward(request, response);
                break;
            case CREATE_INVITE:
                createInvite(request, response);
//                request.setAttribute("users", UserDAO.retrieveUserList());
//                request.getRequestDispatcher("allUsers.jsp").forward(request, response);
                break;


        }

    }

    private void createInvite(HttpServletRequest request, HttpServletResponse response) {
        //arreglar este caos

        StringTokenizer st = new StringTokenizer(request.getParameter("amigos"),",");

        List<User> userList = new ArrayList<User>();
        while (st.hasMoreTokens()){
            userList.add(UserDAO.retrieveUserbyNickName(st.nextToken()));
//            System.out.println(st.nextToken());
        }

        userList.add(UserDAO.retrieveUserbyNickName(request.getRemoteUser()));

        Place place = PlaceDAO.retrievePlacesbyId(Long.valueOf(request.getParameter("placeId")));

        Invitation invitation = new Invitation(place,userList,request.getParameter("timepicker"));



        InviteDAO.persist(invitation);

//        for (User u:userList){
//            u.getInvitations().add(invitation);
//            dao.persist(u);
//        }

        System.out.println(invitation.getPlace().getName());
        System.out.println(invitation.getDate());


    }

    private void makeAdmin(HttpServletRequest request, HttpServletResponse response) {
        User user = UserDAO.retrieveUserbyNickName(request.getParameter("name"));
        user.setAdmin(true);
        UserDAO.persist(user);
    }

    private void restoreUser(HttpServletRequest request, HttpServletResponse response) {
        User user = UserDAO.retrieveUserbyNickName(request.getParameter("name"));
        user.setDeleted(false);
        UserDAO.persist(user);
    }

    private void locateFriend(HttpServletRequest request, HttpServletResponse response) {
        sendFriendLocationJson(request, response);


    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        User user = UserDAO.retrieveUserbyNickName(request.getParameter("name"));
        user.setDeleted(true);
        UserDAO.persist(user);
    }

    private void addFavouritePlace(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("EL VALOR DEL STRINGGGGGGGGG");
        System.out.println(request.getParameter("place_id"));

        Place place = PlaceDAO.retrievePlacesbyId((Long.valueOf(request.getParameter("place_id"))));
        User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser());
        if (!user.getFavouritePlaces().contains(place)) {
            user.getFavouritePlaces().add(place);
            UserDAO.persist(user);
        }


    }

    private void updateLocation(HttpServletRequest request, HttpServletResponse response) {
        User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser());
        Location location = new Location(Double.parseDouble(request.getParameter("latitude")), Double.parseDouble(request.getParameter("longitude")));
        LocationDAO.persist(location);
        user.setLastLocation(location);
        UserDAO.persist(user);
    }

    private void modifyUser(HttpServletRequest request, HttpServletResponse response) {
        User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser());
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
        String message = "Welcome " + name + " ! The CoffeeBreak staff welcomes you to CoffeeBreak! Username: " + name + " Password: " + pass;
        mailer.sendMail(request.getParameter("mail"), "Welcome to CoffeeBreak", message);

    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response) {
        User user = UserDAO.retrieveUserbyNickName(request.getRemoteUser());
        User friend = UserDAO.retrieveUserbyEmail(request.getParameter("email"));


        String message = user.getNickName() + " has sent you an invitation to COFFEEBREAK! Go to www.coffeebreakapp.com.ar to register";


        if (friend != null) {

            user.getFriends().add(friend);
            friend.getFriends().add(user);
            dao.persist(user);
            dao.persist(friend);

            /*TEST PARA VER QUE ESTA HACIENDO ADDFRIEND!!*/

            System.out.println(user.getNickName() + " y " + friend.getNickName() + " ya son amigos!");

            System.out.println("Los amigos de " + user.getNickName() + " son:");
            Iterator<User> iterator = user.getFriends().iterator();

            while (iterator.hasNext()) {
                User pepi = iterator.next();
                System.out.println(pepi.getNickName());

            }
            System.out.println("---------------");
            System.out.println("Los amigos de " + friend.getNickName() + " son:");
            iterator = friend.getFriends().iterator();
            while (iterator.hasNext()) {
                User pepi = iterator.next();
                System.out.println(pepi.getNickName());

            }

            /*END TEST!! BORRAAAAR*/

        } else {
            Emailer mailer = new Emailer();
            mailer.sendMail(request.getParameter("email"), "COFFEEBREAK invitation", message);

        }
    }

    public String toJSONString(List<User> friends) {
        JSONArray jsonFriends = new JSONArray();
        for (User friend : friends) {
            jsonFriends.put(friend.getNickName());
            jsonFriends.put(friend.getLastLocation().getLatitude());
            jsonFriends.put(friend.getLastLocation().getLongitude());
        }
        System.out.println(jsonFriends.toString());
        return jsonFriends.toString();
    }

    public String toJSONString(Location friendLocation) {
        JSONArray jsonFriendLocation = new JSONArray();

        jsonFriendLocation.put(friendLocation.getLatitude());
        jsonFriendLocation.put(friendLocation.getLongitude());

        System.out.println(jsonFriendLocation.toString());
        return jsonFriendLocation.toString();
    }

    public void sendFriendsJson(HttpServletRequest request, HttpServletResponse response) {

        List<User> friends = new ArrayList<User>(UserDAO.retrieveUserbyNickName(request.getRemoteUser()).getFriends());

        String json = toJSONString(friends);

        response.setContentType("text/json");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(json);
        } catch (
                IOException e
                ) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }

    public void sendFriendLocationJson(HttpServletRequest request, HttpServletResponse response) {

        Location friendLocation = UserDAO.retrieveUserbyNickName(request.getParameter("name")).getLastLocation();

        String json = toJSONString(friendLocation);

        response.setContentType("text/json");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(json);
        } catch (
                IOException e
                ) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }


}