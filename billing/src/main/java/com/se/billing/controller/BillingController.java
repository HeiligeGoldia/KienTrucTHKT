package com.se.billing.controller;

import com.se.billing.entity.Billing;
import com.se.billing.entity.Passenger;
import com.se.billing.entity.ResponseTemplate;
import com.se.billing.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getByBillId/{bid}")
    public ResponseTemplate getByBillId(@PathVariable("bid") int bid){
        ResponseTemplate re = new ResponseTemplate();
        Billing b = billingRepository.getById(bid);
        String url = "http://192.168.182.168:8081/api/passenger/getById/" + b.getPid();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Passenger p = restTemplate.exchange(url, HttpMethod.GET, entity, Passenger.class).getBody();

        re.setBilling(b);
        re.setPassenger(p);
        return re;
    }

}
