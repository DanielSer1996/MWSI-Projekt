package i5b5.mwsi.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by daniel on 05.11.17.
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        Properties dbConnectionProperties = new Properties();
        try {
            dbConnectionProperties.load(HibernateUtil.class.getClassLoader().getResourceAsStream("hibernate2.properties"));
            return new Configuration().mergeProperties(dbConnectionProperties).configure("hibernate.cfg.xml").buildSessionFactory();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized static SessionFactory getSessionFactory() {
        if(sessionFactory != null) {
            return sessionFactory;
        }else{
            sessionFactory = buildSessionFactory();
            return sessionFactory;
        }
    }
}
