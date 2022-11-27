package com.se.billing.entity;

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
@Table(name = "billing")
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "bill_id")
    private int bid;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "passenger_id")
    private int pid;

}