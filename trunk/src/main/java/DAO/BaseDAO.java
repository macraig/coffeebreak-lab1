package DAO;

import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class BaseDAO {
	
    public static void persist(Object pojo) {
        try {
            HibernateUtil.getSession().saveOrUpdate(pojo);
            HibernateUtil.beginTransaction();
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }
    


    public static void delete(Object pojo) {
        org.hibernate.Session session = HibernateUtil.getSession();
        try {
            HibernateUtil.getSession().delete(pojo);
            HibernateUtil.beginTransaction();
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    public static boolean appendAnd(StringBuffer stringBuffer, boolean and) {
        if (and) {
            stringBuffer.append("and ");
        }
        return true;
    }

    public static <T> List<T> retrieveObject(T object, Query query) {
        return query.list();
    }

}
