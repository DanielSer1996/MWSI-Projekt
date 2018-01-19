package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.Car;
import i5b5.mwsi.services.CarService;
import i5b5.mwsi.services.dto.CarData;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class CarServiceImpl implements CarService {

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = Logger.getLogger(CarServiceImpl.class);

    @Override
    public List<CarData> listCars() {
        String hql = new StringBuilder()
                .append("SELECT c.vin,")
                .append("c.carMake,")
                .append("c.carModel,")
                .append("c.carRegistrationNumber,")
                .append("i.insuranceId\n")
                .append("FROM Car AS c\n")
                .append("JOIN c.insurance i")
                .toString();

        List<Object[]> resultList = entityManager.createQuery(hql).getResultList();

        String hql2 = new StringBuilder()
                .append("SELECT cr.reviewId\n")
                .append("FROM CarReview cr\n")
                .append("JOIN cr.reviewedCar rc\n")
                .append("WHERE rc.vin = ?1")
                .toString();

        String hql3 = new StringBuilder()
                .append("SELECT ors.pesel\n")
                .append("FROM Car AS c\n")
                .append("JOIN c.owners ors\n")
                .append("WHERE c.vin = ?1")
                .toString();

        List<CarData> carData = new ArrayList<>();
        for (Object[] arr : resultList) {
            CarData data = new CarData();
            data.setVin((String) arr[0]);
            data.setCarMake((String) arr[1]);
            data.setCarModel((String) arr[2]);
            data.setCarRegistrationNumber((String) arr[3]);
            data.setInsuranceNumber((Long) arr[4]);

            List<String> reviews = entityManager.createQuery(hql2, String.class).setParameter(1, (String) arr[0]).getResultList();
            List<String> owners = entityManager.createQuery(hql3, String.class).setParameter(1, (String) arr[0]).getResultList();
            data.setReviews(reviews);
            data.setOwners(owners);

            carData.add(data);
        }

        return carData;
    }

    @Override
    public List<CarData> getSpecifiedCars(String criteria) {

        criteria = criteria.toLowerCase();
        List<CarData> carList = listCars();
        List<CarData> specifiedCars = new ArrayList<>();
        for (CarData carData : carList) {
            if ((carData.getVin().toLowerCase().contains(criteria) ||
                    carData.getCarRegistrationNumber().toLowerCase().contains(criteria)) ||
                    Long.toString(carData.getInsuranceNumber()).contains(criteria)) {
                specifiedCars.add(carData);
            }
        }

        return specifiedCars;
    }


    private List<CarData> createCarDataListFromCarList(List<Car> cars) {
        List<CarData> basicDriverInfoList = new ArrayList<>();
        for (Car car : cars) {
            basicDriverInfoList.add(new CarData(car));
        }

        return basicDriverInfoList;
    }
}
