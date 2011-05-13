package tests;

import DAO.LocationDAO;
import DAO.PlaceDAO;
import DAO.UserDAO;
import model.Location;
import model.Place;
import model.User;

/**
 * Created by IntelliJ IDEA.
 * User: Mary Anne
 * Date: 5/8/11
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class Test {

    public static void main(String[] args) {

        Place p = new Place("The Coffee Store","Paseo Colon 123");
       // Location loc = new Location(951,684);


       // LocationDAO ldao = new LocationDAO();
       // ldao.persist(loc);
        // p.setLocation(loc);
       // dao.persist(user);
       // pdao.persist(p);

        User a = new User("Mary", "mardybum");
        User b = new User("Chelen", "catcopy");
         a.getFriends().add(b);
        a.getFavouritePlaces().add(p);

        UserDAO dao = new UserDAO();

        dao.persist(a);

        dao.persist(b);








	}






}
