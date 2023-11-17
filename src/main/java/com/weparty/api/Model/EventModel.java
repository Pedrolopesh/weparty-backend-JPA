package com.weparty.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Event")
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="startDate")
    private String startDate;

    @Column(name="endDate")
    private String endDate;

    @Column(name="country")
    private String country;

    @Column(name="zipCode")
    private String zipCode;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="district")
    private String district;

    @Column(name="street")
    private String street;

    @Column(name="number")
    private String number;

    @Column(name="eventUserId")
    private Long eventUserId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserSystemModel user;

    @Transient
    private UserResponseModel userResponse;

    public UserResponseModel getUserResponse() {
        return userResponse;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getEventUserId() {
        return eventUserId;
    }

    public void setUserResponse(UserResponseModel userResponse) {
        this.userResponse = userResponse;
    }
}
