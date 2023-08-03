package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    @SequenceGenerator(name = "address_address_id_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
    private int addressId;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "address2", nullable = true, length = 50)
    private String address2;

    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @Column(name = "city_id", nullable = false)
    private int cityId;

    @Column(name = "postal_code", nullable = false, length = 6)
    private String postalCode;

    @Column(name = "phone", nullable = true, length = 20)
    private String phoneNo;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;


    public Address(int addressId, String address, String address2, String district, int cityId, String postalCode, String phoneNo, LocalDateTime lastUpdate) {
        this.addressId = addressId;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.cityId = cityId;
        this.postalCode = postalCode;
        this.phoneNo = phoneNo;
        this.lastUpdate = lastUpdate;
    }

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", cityId=" + cityId +
                ", postalCode='" + postalCode + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
