package DAO;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;


public class BaseDAO {
	
    public static void persist(Object pojo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.saveOrUpdate(pojo);
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
    


    public static void delete(Object pojo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.delete(pojo);
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static boolean appendAnd(StringBuffer stringBuffer, boolean and) {
        if (and) {
            stringBuffer.append("and ");
        }
        return true;
    }

    public static <T> List<T> retrieveObject(T object, Query query) {
        List<T> list = new ArrayList<T>();
        org.hibernate.classic.Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            list = query.list();
        } finally {
            session.close();
        }
        return list;
    }

}
