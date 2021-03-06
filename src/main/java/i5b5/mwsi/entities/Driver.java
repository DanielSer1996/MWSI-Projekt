package i5b5.mwsi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 05.11.17.
 */
@JsonFormat
@Entity
@Table(name = "DRIVER")
public class Driver implements Serializable {
    @Id
    @Column(name = "DRIVER_ID")
    private long driverId;
    @Column(name = "DRIVER_PESEL")
    private String pesel;
    @Column(name = "DRIVER_NAME")
    private String name;
    @Column(name = "DRIVER_SURNAME")
    private String surname;
    @Column(name = "DRIVER_BIRTH_DATE")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "LICENSE_ID")
    private DrivingLicense drivingLicense;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @ManyToMany(mappedBy = "owners")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Car> cars = new ArrayList<>();

    public Driver(long driverId, String pesel, String name, String surname, Date birthDate) {
        this.driverId = driverId;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Driver() {
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(DrivingLicense drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
