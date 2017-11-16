package i5b5.mwsi.endpoints;

import i5b5.mwsi.entities.Driver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;


/**
 * Created by daniel on 15.11.17.
 */
@RestController
@ComponentScan("")
public class DriverController {

    @RequestMapping(value = "/driver",method = RequestMethod.GET)
    public Driver getDriverById(){
//        HibernateUtil hibernateUtil = new HibernateUtil();
//        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();

        return new Driver(1L,"12345678901","Daniel","Serszeń",Date.valueOf("1996-07-31"));
    }
}
