package servlets;

import hibernate.HibernateUtil;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //Nothing to do here
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HibernateUtil.disconnectSession();
        HibernateUtil.closeSession();
    }
}
