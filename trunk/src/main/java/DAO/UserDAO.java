package DAO;

import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


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

	public static void updatePassword(String nickName, String password) {
		List<User> userList = new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String query = "from User where nickName ='" + nickName + "' ";
			userList = session.createQuery(query).list();
		} finally {
			session.close();
		}
		User user = userList.get(0);
		user.setPassword(password);
		persist(user);
	}
	
	public static void updateLocation(String nickName, Location location) {
		List<User> userList = new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String query = "from User where nickName ='" + nickName + "' ";
			userList = session.createQuery(query).list();
		} finally {
			session.close();
		}
		User user = userList.get(0);
		user.setLastLocation(location);
		persist(user);
	}
	

	public static void createUser(String name, String password){
		User user = new User (name,password);
		persist(user);
	}
	
	//public void deleteUser(Long userId){
		//User user=(User) session.get(User.class,userId);
		//delete(user);
		//retrieveObject?
	//}
	

	
}