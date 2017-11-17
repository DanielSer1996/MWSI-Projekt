package i5b5.mwsi.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by daniel on 05.11.17.
 */
public class HibernateUtil {
    private SessionFactory sessionFactory;

    public HibernateUtil() {
        this.sessionFactory = buildSessionFactory();
    }

    private SessionFactory buildSessionFactory() {
        Properties dbConnectionProperties = new Properties();
        try {
            dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch(Exception e) {
            return null;
        }

        return new Configuration().mergeProperties(dbConnectionProperties).configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
