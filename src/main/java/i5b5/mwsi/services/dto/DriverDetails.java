package i5b5.mwsi.services.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DriverDetails{
    private Long driverId;
    private String pesel;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String drivingLicenseNumber;
    private AddressData address;
    private List<LicenseCategoryData> categories;

    public DriverDetails(Long driverId,
                         String pesel,
                         String name,
                         String surname,
                         Date dateOfBirth,
                         String drivingLicenseNumber,
                         AddressData addressData) {
        this.driverId = driverId;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.address = addressData;
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

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public AddressData getAddressData() {
        return address;
    }

    public void setAddressData(AddressData address) {
        this.address = address;
    }

    public List<LicenseCategoryData> getCategories() {
        return categories;
    }

    public void setCategories(List<LicenseCategoryData> categories) {
        this.categories = categories;
    }
}
