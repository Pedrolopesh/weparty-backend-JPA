package com.weparty.api.Model;

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
    private Date startDate;

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
}
