package test;

import DAO.LocationDAO;
import DAO.UserDAO;
import model.Location;
import model.User;

/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 6/10/11
 * Time: 8:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateAdmin {

   // static User admin = new User("admin","admin","mail@admin.com");
   static User pepe = new User("africano","test","mail@test.com");

    public static void main(String[] args) {
        //admin.setAdmin(true);
       // UserDAO.persist(admin);
        Location l = new Location(0,0);
        pepe.setLastLocation(l);
        LocationDAO.persist(l);
        UserDAO.persist(pepe);
    }

}
