package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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

}
