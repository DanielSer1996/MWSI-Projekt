package i5b5.mwsi.services.impl;

import i5b5.mwsi.controllers.requests.TicketRequest;
import i5b5.mwsi.controllers.responses.TicketResponse;
import i5b5.mwsi.entities.CriminalRecords;
import i5b5.mwsi.entities.Driver;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.AddressData;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@Transactional
@Repository
public class DriverServiceImpl implements DriverService {

    private final Logger logger = Logger.getLogger(DriverServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TicketResponse insertTicket(TicketRequest request) {
        CriminalRecords criminalRecords = new CriminalRecords();
        criminalRecords.setDriver(entityManager.find(Driver.class, request.getDriverId()));
        criminalRecords.setCashAmount(request.getCashAmount());
        criminalRecords.setPenaltyPoints(request.getPenaltyPoints());
        criminalRecords.setIssueDate(request.getIssueDate());
        criminalRecords.setDescription(request.getDescription());

        entityManager.persist(criminalRecords);

        TicketResponse response = new TicketResponse();

        response.setDriverPenaltyPoints(getPenaltyPointsForDriver(request.getDriverId()));

        return response;
    }

    @Override
    public List<BasicDriverInfo> getDrivers() {
        logger.info("Started getting drivers");

        String hql = "SELECT dr.driverId AS driverId," +
                "dr.pesel AS pesel," +
                "dr.name AS name," +
                "dr.surname AS surname," +
                "dl.licenseNumber AS driverLicenseNumber\n" +
                "FROM Driver dr\n" +
                "JOIN dr.drivingLicense dl";

        List<Object[]> resultList = entityManager.createQuery(hql).getResultList();

        List<BasicDriverInfo> result = new ArrayList<>();
        for (Object[] arr : resultList) {
            BasicDriverInfo basicDriverInfo = new BasicDriverInfo();
            basicDriverInfo.setDriverId((long) arr[0]);
            basicDriverInfo.setPesel((String) arr[1]);
            basicDriverInfo.setName((String) arr[2]);
            basicDriverInfo.setSurname((String) arr[3]);
            basicDriverInfo.setDriverLicenseNumber((String) arr[4]);
            result.add(basicDriverInfo);
        }

        logger.info("Drivers got from database");

        return result;
    }

    private Long getPenaltyPointsForDriver(Long driverId) {
        String hql = "select sum(cr.penaltyPoints) from CriminalRecords cr join cr.driver d where d.driverId = ?1";
        return entityManager.createQuery(hql, Long.class).setParameter(1, driverId).getSingleResult();
    }


    @Override
    public DriverDetails getDriverById(long id) {
        logger.info("Looking for driver by id");
        Driver driver = entityManager.find(Driver.class, id);
        logger.info("Looking for driver ended");
        DriverDetails details = new DriverDetails(driver.getDriverId(),
                driver.getPesel(),
                driver.getName(),
                driver.getSurname(),
                driver.getBirthDate(),
                driver.getDrivingLicense().getLicenseNumber(),
                new AddressData(driver.getAddress()));
        details.setPenaltyPoints(getPenaltyPointsForDriver(id));
        details.setCategories(getLicenseCategories(details.getDrivingLicenseNumber()));
        return details;
    }

    @Override
    public List<BasicDriverInfo> getSpecifiedDrivers(String criteria) {
        criteria = criteria.toLowerCase();
        List<BasicDriverInfo> drivers = getDrivers();
        List<BasicDriverInfo> specifiedDrivers = new ArrayList<>();
        for (BasicDriverInfo driverInfo : drivers) {
            if ((driverInfo.getName().toLowerCase().contains(criteria)
                    || driverInfo.getSurname().toLowerCase().contains(criteria)
                    || driverInfo.getPesel().toLowerCase().contains(criteria))
                    || driverInfo.getDriverLicenseNumber().toLowerCase().contains(criteria)) {
                specifiedDrivers.add(driverInfo);
            }
        }

        return specifiedDrivers;
    }


    @Override
    public List<String> getLicenseCategories(String licenseId) {
        String hql = new StringBuilder().
                append("SELECT ct.categoryType \n").
                append("FROM DrivingLicense dl\n").
                append("JOIN dl.categories ct \n").
                append("WHERE dl.licenseNumber = ?1").toString();

        Query query = entityManager.createQuery(hql, String.class).setParameter(1,licenseId);
        return query.getResultList();
    }

    private List<BasicDriverInfo> createBasicDriverInfoListFromDriverList(List<Driver> drivers) {
        List<BasicDriverInfo> basicDriverInfoList = new ArrayList<>();
        for (Driver driver : drivers) {
            basicDriverInfoList.add(new BasicDriverInfo(driver));
        }

        return basicDriverInfoList;
    }
}
