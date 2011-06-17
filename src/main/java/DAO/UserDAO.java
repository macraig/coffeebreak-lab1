package DAO;

import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class UserDAO extends BaseDAO {

    public static User retrieveUserbyNickName(String aux) {
        User result = null;
        Session session = HibernateUtil.getSession();
        String query = "from User where nickName ='" + aux + "' ";
        result = (User) session.createQuery(query).uniqueResult();
        return result;
    }

    public static List<User> retrieveUserbyEmail(String aux) {
        List<User> userList = new ArrayList<User>();
        Session session = HibernateUtil.getSession();
        String query = "from User where email ='" + aux + "' ";
        userList = session.createQuery(query).list();
        return userList;
    }


}