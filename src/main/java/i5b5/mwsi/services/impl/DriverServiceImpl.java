package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.CriminalRecords;
import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.DriverDTO;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class DriverServiceImpl implements DriverService{
    private final SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();

    @Override
    public Set<DriverDTO> getDrivers() {
        return null;
    }

    @Override
    public DriverDTO getDriverById(long id) {
        Session session = sessionFactory.openSession();

        Driver driver = session.get(Driver.class,id);

        session.close();

        return new DriverDTO(driver);
    }
}
