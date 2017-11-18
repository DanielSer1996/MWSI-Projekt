package i5b5.mwsi.endpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DBService;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by daniel on 15.11.17.
 */
@Controller
@RequestMapping("/drivers")
public class DriverController {
    private DBService dbService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody String getDriverById(@PathVariable long id){
        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Driver driver = session.get(Driver.class,id);

        session.close();
        sessionFactory.close();

        return driver.getSurname();
    }
}
