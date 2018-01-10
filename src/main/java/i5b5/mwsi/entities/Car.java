package i5b5.mwsi.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAR")
public class Car implements Serializable {
    @Id
    @Column(name = "CAR_VIN")
    private String vin;
    @Column(name = "CAR_MAKE")
    private String carMake;
    @Column(name = "CAR_MODEL")
    private String carModel;
    @Column(name = "CAR_REGISTRATION_NUMBER")
    private String carRegistrationNumber;
    @OneToMany(mappedBy = "reviewedCar",fetch = FetchType.EAGER)
    private List<CarReview> reviews = new ArrayList<CarReview>();

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "DRIVER_CAR_REL",
            joinColumns = {@JoinColumn(name = "CAR_VIN")},
            inverseJoinColumns = {@JoinColumn(name = "DRIVER_ID")}
    )
    private List<Driver> owners = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "INSURANCE_ID")
    private Insurance insurance;

    public Car() {
    }

    public Car(String carVin, String carMake, String carModel, String carRegistrationNumber) {
        this.vin = carVin;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carRegistrationNumber = carRegistrationNumber;
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public List<CarReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<CarReview> reviews) {
        this.reviews = reviews;
    }

    public List<Driver> getOwners() {
        return owners;
    }

    public void setOwners(List<Driver> owners) {
        this.owners = owners;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
