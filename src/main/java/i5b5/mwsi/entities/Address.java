package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {



    @Id
    @Column (name = "ADDRESS_ID")
    private long addressId;

    @Column (name = "ADDRESS_LOCALITY")
    private String addressLocality;

    @Column (name = "ADDRESS_STREET")
    private String addressStreet;

    @Column (name = "ADDRESS_ZIPCODE")
    private String addressZipcode;

    @Column (name = "ADDRESS_VOIVODESHIP")
    private String addressVoivodeship;

    @Column (name = "ADDRESS_STREET_NUMBER")
    private String addressStreetNumber;

    @Column (name = "ADDRESS_APARTMENT_NUMBER")
    private String addressApartmentNumber;

    public Address(long addressId, String addressLocality, String addressStreet, String addressZipcode, String addressVoivodeship, String addressStreetNumber, String addressApartmentNumber){

        this.addressId = addressId;
        this.addressLocality = addressLocality;
        this.addressStreet = addressStreet;
        this.addressZipcode = addressZipcode;
        this.addressVoivodeship = addressVoivodeship;
        this.addressStreetNumber = addressStreetNumber;
        this.addressApartmentNumber = addressApartmentNumber;

    }

    public Address(){

    }

    public long getAddressId() {
        return addressId;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public String getAddressVoivodeship() {
        return addressVoivodeship;
    }

    public String getAddressStreetNumber() {
        return addressStreetNumber;
    }

    public String getAddressApartmentNumber() {
        return addressApartmentNumber;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
    }

    public void setAddressVoivodeship(String addressVoivodeship) {
        this.addressVoivodeship = addressVoivodeship;
    }

    public void setAddressStreetNumber(String addressStreetNumber) {
        this.addressStreetNumber = addressStreetNumber;
    }

    public void setAddressApartmentNumber(String addressApartmentNumber) {
        this.addressApartmentNumber = addressApartmentNumber;
    }
}


