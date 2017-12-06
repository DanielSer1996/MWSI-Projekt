package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.Address;
import i5b5.mwsi.entities.Car;
import i5b5.mwsi.entities.Driver;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class DriverDetails {
    private Long driverId;
    private String pesel;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Long drivingLicenseNumber;
    private AddressDTO address;
    private Set<String> ownedCarsVins = new HashSet<String>();

    public DriverDetails(Driver driver) {
        this.driverId = driver.getDriverId();
        this.pesel = driver.getPesel();
        this.name = driver.getName();
        this.surname = driver.getSurname();
        this.dateOfBirth = driver.getBirthDate();
        this.drivingLicenseNumber = driver.getDrivingLicense().getLicenseId();
        this.address = new AddressDTO(driver.getAddress());
        for(Car c : driver.getCars()){
            this.ownedCarsVins.add(c.getVin());
        }
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(Long drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public AddressDTO getAddressDTO() {
        return address;
    }

    public void setAddressDTO(AddressDTO address) {
        this.address = address;
    }

    public Set<String> getOwnedCarsVins() {
        return ownedCarsVins;
    }

    public void setOwnedCarsVins(Set<String> ownedCarsVins) {
        this.ownedCarsVins = ownedCarsVins;
    }
}
