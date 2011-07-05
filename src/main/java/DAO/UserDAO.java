package DAO;

import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;

import java.util.List;


public class UserDAO extends BaseDAO {

    public static User retrieveUserbyNickName(String aux) {
        HibernateUtil.closeSession();
        User result = null;
        Session session = HibernateUtil.getSession();
        String query = "from User where nickName ='" + aux + "' ";
        result = (User) session.createQuery(query).uniqueResult();
        return result;
    }

    public static User retrieveUserbyEmail(String aux) {
        User result = null;
        Session session = HibernateUtil.getSession();
        String query = "from User where email ='" + aux + "' ";
        result = (User)session.createQuery(query).uniqueResult();
        return result;
    }

    public static List<User> retrieveUserList() {
        String query ="from User";
        User result = null;
        Session session = HibernateUtil.getSession();
        return session.createQuery(query).list();


     }

}