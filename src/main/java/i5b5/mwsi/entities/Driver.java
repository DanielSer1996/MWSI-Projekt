package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by daniel on 05.11.17.
 */
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
    //trzeba będzie dodać relacje po stworzeniu tabel driving_license i address (nie będzie long tylko Address i DrivingLicense)
    @Column(name = "LICENSE_ID")
    private long licenseId;

    @Column(name = "ADDRESS_ID")
    private long addressId;

    public Driver(long driverId, long licenseId, String pesel, String name, String surname, Date birthDate) {
        this.driverId = driverId;
        this.licenseId = licenseId;
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
}
