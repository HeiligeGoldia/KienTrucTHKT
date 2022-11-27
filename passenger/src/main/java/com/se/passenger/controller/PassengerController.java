package com.se.passenger.controller;

import com.se.passenger.entity.Passenger;
import com.se.passenger.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/getById/{pid}")
    public Passenger getById(@PathVariable("pid") int pid){
        return passengerRepository.getById(pid);
    }

}
