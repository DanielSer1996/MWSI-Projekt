package i5b5.mwsi.services.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import i5b5.mwsi.entities.Car;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties("addressData")
public class DriverDetails{
    private Long driverId;
    private String pesel;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Long drivingLicenseNumber;
    private Set<String> ownedCarsVins = new HashSet<>();
    @JsonUnwrapped(prefix = "address.")
    private AddressData address;

    @JsonCreator
    public DriverDetails(@JsonProperty("driverId")Long driverId,
                         @JsonProperty("pesel")String pesel,
                         @JsonProperty("name")String name,
                         @JsonProperty("surname")String surname,
                         @JsonProperty("dateOfBirth")Date dateOfBirth,
                         @JsonProperty("drivingLicenseNumber")Long drivingLicenseNumber,
                         @JsonProperty("ownedCarVins")List<Car> cars,
                         @JsonProperty AddressData addressData) {
        this.driverId = driverId;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.address = addressData;
        for(Car c : cars) {
            this.ownedCarsVins.add(c.getVin());
        }

    }

//    public void addDataFromDriver(Long driverId,
//                                  String pesel,
//                                  String name,
//                                  String surname,
//                                  Date dateOfBirth,
//                                  Long drivingLicenseNumber,
//                                  List<Car> cars,
//                                  AddressData addressData){
//        this.driverId = driverId;
//        this.pesel = pesel;
//        this.name = name;
//        this.surname = surname;
//        this.dateOfBirth = dateOfBirth;
//        this.drivingLicenseNumber = drivingLicenseNumber;
//        this.address = addressData;
//        for(Car c : cars){
//            this.ownedCarsVins.add(c.getVin());
//        }
//    }

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

    public AddressData getAddressData() {
        return address;
    }

    public void setAddressData(AddressData address) {
        this.address = address;
    }

    public Set<String> getOwnedCarsVins() {
        return ownedCarsVins;
    }

    public void setOwnedCarsVins(Set<String> ownedCarsVins) {
        this.ownedCarsVins = ownedCarsVins;
    }
}
