package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.Car;
import i5b5.mwsi.services.CarService;
import i5b5.mwsi.services.dto.CarData;
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

    @Override
    public List<CarData> listCars() {
        String hql = "FROM Car";
        System.out.println("Test");
        return createCarDataListFromCarList(entityManager.createQuery(hql,Car.class).getResultList()) ;
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
