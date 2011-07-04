package test;

import DAO.LocationDAO;
import DAO.UserDAO;
import model.Location;
import model.User;

/**
 * Created by IntelliJ IDEA.
 * User: Mary Anne
 * Date: 6/28/11
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateUser {


    static User pepe = new User("africano","africa","mail@africano.com");

    public static void main(String[] args) {

        Location l = new Location(0,0);
        pepe.setLastLocation(l);
        LocationDAO.persist(l);
        UserDAO.persist(pepe);
    }

}
