package i5b5.mwsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "INSURANCE_ID")
    private long insuranceId;
    @Column(name = "CAR_MAKE")
    private String carMake;
    @Column(name = "CAR_MODEL")
    private String carModel;
    @Column(name = "CAR_REGISTRATION_NUMBER")
    private String carRegistrationNumber;
    @OneToMany(mappedBy = "reviewedCar",fetch = FetchType.EAGER)
    private List<CarReview> reviews = new ArrayList<>();

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "DRIVER_CAR_REL",
            joinColumns = {@JoinColumn(name = "CAR_VIN")},
            inverseJoinColumns = {@JoinColumn(name = "DRIVER_ID")}
    )
    private List<Driver> owners = new ArrayList<>();

    public Car(String carVin, long insuranceId, String carMake, String carModel, String carRegistrationNumber) {
        this.vin = carVin;
        this.insuranceId = insuranceId;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public Car() {
    }


    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
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
}
