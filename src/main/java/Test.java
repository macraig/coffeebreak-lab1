import DAO.UserDAO;
import model.Location;
import model.Place;
import model.User;

/**
 * Created by IntelliJ IDEA.
 * User: Mary Anne
 * Date: 5/6/11
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test {



    public static void main(String[] args) {
        User u = new User("Chelen","pololo");
        UserDAO udao = new UserDAO();
        udao.persist(u);
           Location loc = new Location(123452,987654);
        Place p = new Place("CoffeeStore","Paseo Colon 123");
    }



}
