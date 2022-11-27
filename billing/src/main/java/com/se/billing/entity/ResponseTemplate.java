package com.se.billing.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResponseTemplate {

    private Billing billing;
    private Passenger passenger;

}
