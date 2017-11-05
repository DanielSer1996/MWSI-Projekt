import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by daniel on 05.11.17.
 */
public class Main {
    public static void main(String[] args) {

    }

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
        }

        return sessionFactory;
    }

}
