package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.Car;
import i5b5.mwsi.services.CarService;
import i5b5.mwsi.services.dto.CarData;
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
public class CarServiceImpl implements CarService{

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<CarData> listCars() {
        List<Car> drivers;
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
        Root<Car> driverRoot = criteriaQuery.from(Car.class);
        criteriaQuery.select(driverRoot);

        drivers = session.createQuery(criteriaQuery).getResultList();


        return createCarDataListFromCarList(drivers);
    }

    @Override
    public List<CarData> getSpecifiedCars(String criteria) {

        criteria = criteria.toLowerCase();
        List<CarData> specifiedCars = new ArrayList<>();
        for(CarData carData : listCars()){
            if((carData.getVin().toLowerCase().contains(criteria) || carData.getCarRegistrationNumber().toLowerCase().contains(criteria))){
                specifiedCars.add(carData);
            }
        }

        return specifiedCars;
    }


    private List<CarData> createCarDataListFromCarList(List<Car> cars){
        List<CarData> basicDriverInfoList = new ArrayList<>();
        for(Car car : cars){
            basicDriverInfoList.add(new CarData(car));
        }

        return basicDriverInfoList;
    }
}
