package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by daniel on 15.11.17.
 */
@Entity
@Table(name = "CAR")
public class Car implements Serializable {
    @Id
    @Column(name = "CAR_VIN")
    private String vin;
    @Column(name = "CAR_MAKE")
    private String manufacturer;
    @Column(name = "CAR_MODEL")
    private String model;
    @Column (name = "CAR_REGISTRATION_NUMBER")
    private String registrationNumber;
}
