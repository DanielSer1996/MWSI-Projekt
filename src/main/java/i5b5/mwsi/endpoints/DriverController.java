package i5b5.mwsi.endpoints;

import i5b5.mwsi.entities.Driver;
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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Driver getDriverById(@PathVariable long id){
        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Driver driver = session.get(Driver.class,id);

        session.close();
        sessionFactory.close();

        return driver;
    }
}
