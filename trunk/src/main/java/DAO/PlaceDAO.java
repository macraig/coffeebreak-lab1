package DAO;

import hibernate.HibernateUtil;
import model.Place;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PlaceDAO extends BaseDAO {

    public static List<Place> retrievePlacesbyName(String name) {
        List<Place> placeList = new ArrayList<Place>();
        Session session = HibernateUtil.getSession();
        String query = "from Place where name ='" + name + "' ";
        placeList = session.createQuery(query).list();
        return placeList;
    }





}
