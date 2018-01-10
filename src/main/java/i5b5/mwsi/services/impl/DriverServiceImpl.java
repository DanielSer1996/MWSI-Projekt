package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.entities.DrivingLicense;
import i5b5.mwsi.entities.LicenseCategory;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.*;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.EntityType;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<BasicDriverInfo> getDrivers() {
        List<Driver> drivers;
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Driver> criteriaQuery = builder.createQuery(Driver.class);
        Root<Driver> driverRoot = criteriaQuery.from(Driver.class);
        criteriaQuery.select(driverRoot);

        drivers = session.createQuery(criteriaQuery).getResultList();

        session.getTransaction().commit();
        session.close();

        return createBasicDriverInfoListFromDriverList(drivers);
    }


    @Override
    public DriverDetails getDriverById(long id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Driver driver = session.get(Driver.class,id);

        session.getTransaction().commit();
        session.close();

        return new DriverDetails(driver.getDriverId(),
                driver.getPesel(),
                driver.getName(),
                driver.getSurname(),
                driver.getBirthDate(),
                driver.getDrivingLicense().getLicenseNumber(),
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

    @Override
    public List<LicenseCategoryData> getLicenseCategories(String licenseId) {
        List<LicenseCategory> categories;
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<LicenseCategory> query = cb.createQuery(LicenseCategory.class);
        Root<DrivingLicense> dl = query.from(DrivingLicense.class);
        Join<DrivingLicense, LicenseCategory> categoriesRes = dl.join("categories");
        query.select(categoriesRes).where(cb.equal(dl.get("licenseNumber"), licenseId));

        categories = session.createQuery(query).getResultList();

        return createLicenseCategoryData(categories);
    }

    private List<BasicDriverInfo> createBasicDriverInfoListFromDriverList(List<Driver> drivers){
        List<BasicDriverInfo> basicDriverInfoList = new ArrayList<>();
        for(Driver driver : drivers){
            basicDriverInfoList.add(new BasicDriverInfo(driver));
        }

        return basicDriverInfoList;
    }

    private List<LicenseCategoryData> createLicenseCategoryData(List<LicenseCategory> categories){
        List<LicenseCategoryData> result = new ArrayList<>();
        for(LicenseCategory licenseCategory : categories){
            result.add(new LicenseCategoryData(licenseCategory));
        }

        return result;
    }
}
