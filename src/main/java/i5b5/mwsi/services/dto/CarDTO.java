package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.Car;
import i5b5.mwsi.entities.CarReview;

import java.util.ArrayList;
import java.util.List;

public class CarDTO
{
    private String vin;
    private String carMake;
    private String carModel;
    private String carRegistrationNumber;
    private List<CarReviewDTO> reviews = new ArrayList<CarReviewDTO>();

    public CarDTO(Car car)
    {
        this.vin = car.getVin();
        this.carMake = car.getCarMake();
        this.carModel = car.getCarModel();
        this.carRegistrationNumber = car.getCarRegistrationNumber();
        for(CarReview review : car.getReviews())
        {
            reviews.add(new CarReviewDTO(review));
        }
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

    public List<CarReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<CarReviewDTO> reviews) {
        this.reviews = reviews;
    }
}
