package main.java.com.sdajava.jpa_ostatnie.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    private final static SessionFactory sf = new Configuration()
            .configure("main/java/com/sdajava/jpa_ostatnie/hibernate.cfg.xml").buildSessionFactory();
    private static Session session = sf.openSession();

    private HibernateConnection() {
    }
    public static Session getHibernateSession() {
        if(session == null) {
            session = (Session) new HibernateConnection();
        }
        return session;
    }
}
