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
        criminalRecords.setDriver(entityManager.find(Driver.class,request.getDriverId()));
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

        String hql = "FROM Driver";

        List<Driver> resultList = entityManager.createQuery(hql, Driver.class).getResultList();


        logger.info("Drivers got from database");

        return createBasicDriverInfoListFromDriverList(resultList);
    }

    private Long getPenaltyPointsForDriver(Long driverId){
        String hql = "select sum(cr.penaltyPoints) from CriminalRecords cr join cr.driver d where d.driverId = ?1";
        return entityManager.createQuery(hql,Long.class).setParameter(1,driverId).getSingleResult();
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
        Callable<List<String>> task = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                String hql = new StringBuilder().
                        append("SELECT ct.categoryType \n").
                        append("FROM DrivingLicense dl\n").
                        append("JOIN dl.categories ct \n").
                        append("WHERE dl.licenseNumber = ?1").toString();

                Query query = entityManager.createQuery(hql, String.class);
                query.setParameter(1,licenseId);
                return query.getResultList();
            }
        };

        List<String> strings = new ArrayList<>();
        try {
            strings = task.call();
        } catch (Exception e) {
            logger.error("Error getting driving license category", e);
        }

        return strings;
    }

    private List<BasicDriverInfo> createBasicDriverInfoListFromDriverList(List<Driver> drivers) {
        List<BasicDriverInfo> basicDriverInfoList = new ArrayList<>();
        for (Driver driver : drivers) {
            basicDriverInfoList.add(new BasicDriverInfo(driver));
        }

        return basicDriverInfoList;
    }
}
