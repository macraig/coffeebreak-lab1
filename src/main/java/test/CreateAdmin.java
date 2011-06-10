package test;

import DAO.UserDAO;
import model.User;

/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 6/10/11
 * Time: 8:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateAdmin {

    static User admin = new User("admin","admin","mail@admin.com");


    public static void main(String[] args) {
        admin.setAdmin(true);
        UserDAO.persist(admin);
    }

}
