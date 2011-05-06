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
	
	
	public static void updateAddress(String nickName, String address) {
		List<Place> placeList = new ArrayList<Place>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String query = "from Place where address ='" + address + "' ";
			placeList = session.createQuery(query).list();
		} finally {
			session.close();
		}
		Place place = placeList.get(0);
		place.setAddress(address);
		persist(place);
	}
	
	public static void updateLocation(String name, Location location) {
		List<Place> placeList = new ArrayList<Place>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String query = "from Place where name ='" + name + "' ";
			placeList = session.createQuery(query).list();
		} finally {
			session.close();
		}
		Place place = placeList.get(0);
		place.setLocation(location);
		persist(place);
	}
	
	
	
	public static void createPlace(String name, String address){
		Place p = new Place (name,address);
		persist(p);
	}
	


}
