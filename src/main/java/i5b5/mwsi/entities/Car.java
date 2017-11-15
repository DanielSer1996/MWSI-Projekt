package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by łukasz on 15.11.17.
 */
@Entity
@Table(name = "CAR")
public class Car implements Serializable {
    @Id
    @Column(name = "CAR_VIN")
    private String carVin;
    @Column(name = "INSURANCE_ID")
    private long insuranceId;
    @Column(name = "CAR_MAKE")
    private String carMake;
    @Column(name = "CAR_MODEL")
    private String carModel;
    @Column(name = "CAR_REGISTRATION_NUMBER")
    private String carRegistrationNumber;

    @Column(name = "ADDRESS_ID")
    private long addressId;

    public Car(String carVin, long insuranceId, String carMake, String carModel, String carRegistrationNumber) {
        this.carVin = carVin;
        this.insuranceId = insuranceId;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public Car() {
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
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

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
}
