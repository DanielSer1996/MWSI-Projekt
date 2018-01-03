package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.Car;
import i5b5.mwsi.entities.CarReview;

import java.util.ArrayList;
import java.util.List;

public class CarData
{
    private String vin;
    private String carMake;
    private String carModel;
    private String carRegistrationNumber;
    private List<String> reviews = new ArrayList<>();
    private long insuranceNumber;

    public CarData(Car car)
    {
        this.vin = car.getVin();
        this.carMake = car.getCarMake();
        this.carModel = car.getCarModel();
        this.carRegistrationNumber = car.getCarRegistrationNumber();
        for(CarReview review : car.getReviews())
        {
            reviews.add(review.getReviewId());
        }
        this.insuranceNumber = car.getInsurance().getInsuranceId();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
