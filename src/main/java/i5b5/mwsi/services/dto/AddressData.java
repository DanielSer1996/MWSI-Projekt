package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.Address;

public class AddressData
{


    private long addressId;
    private String addressLocality;
    private String addressStreet;
    private String addressZipcode;
    private String addressVoivodeship;
    private String addressStreetNumber;
    private String addressApartmentNumber;

    public AddressData(Address address)
    {
        this.addressId = address.getAddressId();
        this.addressLocality = address.getAddressLocality();
        this.addressStreet = address.getAddressStreet();
        this.addressZipcode = address.getAddressZipcode();
        this.addressVoivodeship = address.getAddressVoivodeship();
        this.addressStreetNumber = address.getAddressStreetNumber();
        this.addressApartmentNumber = address.getAddressApartmentNumber();

    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
    }

    public String getAddressVoivodeship() {
        return addressVoivodeship;
    }

    public void setAddressVoivodeship(String addressVoivodeship) {
        this.addressVoivodeship = addressVoivodeship;
    }

    public String getAddressStreetNumber() {
        return addressStreetNumber;
    }

    public void setAddressStreetNumber(String addressStreetNumber) {
        this.addressStreetNumber = addressStreetNumber;
    }

    public String getAddressApartmentNumber() {
        return addressApartmentNumber;
    }

    public void setAddressApartmentNumber(String addressApartmentNumber) {
        this.addressApartmentNumber = addressApartmentNumber;
    }
}
