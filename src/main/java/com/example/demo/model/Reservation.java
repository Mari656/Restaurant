package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by user on 10/04/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @ManyToOne
    private Restaurants restaurant;
    @Column(name = "date_time")
    private String dateTime;
    @Column(name = "number_person")
    private int numberPerson;
    @Column
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

}
