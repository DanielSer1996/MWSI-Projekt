package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.Driver;

public class BasicDriverInfo {
    private Long driverId;
    private String pesel;
    private String name;
    private String surname;
    private String driverLicenseNumber;

    public BasicDriverInfo(Driver driver){
        this.driverId = driver.getDriverId();
        this.pesel = driver.getPesel();
        this.name = driver.getName();
        this.surname = driver.getSurname();
        this.driverLicenseNumber = Long.toString(driver.getDrivingLicense().getLicenseId());
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
