package DAO;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.Place;

import org.hibernate.Session;

public class PlaceDAO extends BaseDAO {
	
	public static List<Place> retrievePlacesbyName(String name) {
		List<Place> placeList = new ArrayList<Place>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String query = "from Place where name ='" + name + "' ";
			placeList = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return placeList;
	}
	

	


}
