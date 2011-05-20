package DAO;

import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class UserDAO extends BaseDAO {

	public static List<User> retrieveUserbyNickName(String aux) {
		List<User> userList = new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String query = "from User where nickName ='" + aux + "' ";
			userList = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return userList;
	}

}