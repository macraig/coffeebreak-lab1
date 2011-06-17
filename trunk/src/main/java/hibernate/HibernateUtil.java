package hibernate;

import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //~ Methods ..............................................................................................

    /**
     * Returns the original Hibernate configuration.
     *
     * @return Configuration
     */
    public static Configuration getConfiguration() {
        return configuration;
    }

    public static Session
    getSession() {
        Session s = threadSession.get();

        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            threadSession.set(s);
        }

        return s;
    }

    /**
     * Start a new database transaction.
     */
    public static void beginTransaction() {
        Transaction tx = threadTransaction.get();

        if (tx == null) {
            System.out.println("Starting new database transaction in this thread.");
            tx = getSession().beginTransaction();
            threadTransaction.set(tx);
        }

    }

    public static void closeSession() {
        Session s = threadSession.get();

        if (s != null && s.isOpen()) {
            s.close();
        }

        threadSession.set(null);
        threadTransaction.set(null);
    }

    /**
     * Commit the database transaction.
     */
    public static void commitTransaction() {
        Transaction tx = threadTransaction.get();

        try {
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                System.out.println("Committing database transaction of this thread.");
                tx.commit();
            }

            threadTransaction.set(null);
        } catch (HibernateException ex) {
            rollbackTransaction();
            throw ex;
        }
    }

    /**
     * Disconnect and return Session from current Thread.
     *
     * @return Session the disconnected Session
     */
    public static Session disconnectSession() {
        Session session = getSession();
        threadSession.set(null);

        if (session.isConnected() && session.isOpen()) {
            session.disconnect();
        }
        return session;
    }

    /**
     * Reconnects a Hibernate Session to the current Thread.
     *
     * @param session The Hibernate Session to be reconnected.
     */
    public static void reconnect(Session session) {
        session.reconnect();
        threadSession.set(session);
    }

    /**
     * Commit the database transaction.
     */
    public static void rollbackTransaction() {
        Transaction tx = threadTransaction.get();

        try {
            threadTransaction.set(null);

            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                System.out.println("Tyring to rollback database transaction of this thread.");
                tx.rollback();
            }
        } finally {
            closeSession();
        }
    }

    //~ Static fields/initializers ...........................................................................

    //private static Log log = LogFactory.getLog(HibernateUtil.class);
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();

    static {
        try {
            // Create the SessionFactory
            configuration = new Configuration().configure("/hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            //log.error("Initial SessionFactory creation failed.", ex);
            System.out.println("Initial SessionFactory creation failed.");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
}
