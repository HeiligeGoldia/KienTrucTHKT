package com.se.passenger.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "passenger_id")
    private int pid;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

}