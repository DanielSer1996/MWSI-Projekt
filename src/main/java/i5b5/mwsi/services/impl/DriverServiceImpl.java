package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.AddressData;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    private final SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();

    @Override
    public List<BasicDriverInfo> getDrivers() {
        List<Driver> drivers;
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Driver> criteriaQuery = builder.createQuery(Driver.class);
        Root<Driver> driverRoot = criteriaQuery.from(Driver.class);
        criteriaQuery.select(driverRoot);

        drivers = session.createQuery(criteriaQuery).getResultList();


        return createBasicDriverInfoListFromDriverList(drivers);
    }


    @Override
    public DriverDetails getDriverById(long id) {
        Session session = sessionFactory.openSession();

        Driver driver = session.get(Driver.class,id);

        session.close();

        return new DriverDetails(driver.getDriverId(),
                driver.getPesel(),
                driver.getName(),
                driver.getSurname(),
                driver.getBirthDate(),
                driver.getDrivingLicense().getLicenseId(),
                driver.getCars(),
                new AddressData(driver.getAddress()));
    }

    @Override
    public List<BasicDriverInfo> getSpecifiedDrivers(String criteria) {
        criteria = criteria.toLowerCase();
        List<BasicDriverInfo> specifiedDrivers = new ArrayList<>();
        for(BasicDriverInfo driverInfo : getDrivers()){
            if((driverInfo.getName().toLowerCase().contains(criteria) || driverInfo.getSurname().toLowerCase().contains(criteria) || driverInfo.getPesel().toLowerCase().contains(criteria))){
                specifiedDrivers.add(driverInfo);
            }
        }

        return specifiedDrivers;
    }

    private List<BasicDriverInfo> createBasicDriverInfoListFromDriverList(List<Driver> drivers){
        List<BasicDriverInfo> basicDriverInfoList = new ArrayList<>();
        for(Driver driver : drivers){
            basicDriverInfoList.add(new BasicDriverInfo(driver));
        }

        return basicDriverInfoList;
    }
}
