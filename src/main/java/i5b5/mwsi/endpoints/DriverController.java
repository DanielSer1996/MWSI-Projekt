package i5b5.mwsi.endpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import i5b5.mwsi.entities.CriminalRecords;
import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DBService;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

        CriminalRecords criminalRecords = session.get(CriminalRecords.class,3L);
        session.close();
        sessionFactory.close();

        System.out.println(criminalRecords.getRecordId()+" "+criminalRecords.getDriver().getName()+ " " + criminalRecords.getDriver().getSurname()+" "+criminalRecords.getType().getCrDictionaryType());

        return driver.getSurname();
    }
}
