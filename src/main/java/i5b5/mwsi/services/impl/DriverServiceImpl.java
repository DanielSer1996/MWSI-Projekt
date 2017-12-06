package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.DriverDTO;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DriverServiceImpl implements DriverService{
    private final SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();

    @Override
    public List<DriverDTO> getDrivers() {
        List<Driver> drivers;
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Driver> criteriaQuery = builder.createQuery(Driver.class);
        Root<Driver> driverRoot = criteriaQuery.from(Driver.class);
        criteriaQuery.select(driverRoot);

        drivers = session.createQuery(criteriaQuery).getResultList();

        return createDriverDTOListFromDriverList(drivers);
    }

    @Override
    public DriverDTO getDriverById(long id) {
        Session session = sessionFactory.openSession();

        Driver driver = session.get(Driver.class,id);

        session.close();

        return new DriverDTO(driver);
    }

    private List<DriverDTO> createDriverDTOListFromDriverList(List<Driver> drivers){
        List<DriverDTO> driverDTOs = new ArrayList<>();
        for(Driver driver : drivers){
            driverDTOs.add(new DriverDTO(driver));
        }

        return driverDTOs;
    }
}
