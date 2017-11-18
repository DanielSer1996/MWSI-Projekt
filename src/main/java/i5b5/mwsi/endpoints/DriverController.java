package i5b5.mwsi.endpoints;

import i5b5.mwsi.entities.Car;
import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DBService;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by daniel on 15.11.17.
 */
@RestController
@RequestMapping("/drivers")
public class DriverController {

     DBService dbService;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Car getDriverById(@PathVariable String id){
        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Car driver = session.get(Car.class,id);

        session.close();
        sessionFactory.close();

        return driver;
    }
}
