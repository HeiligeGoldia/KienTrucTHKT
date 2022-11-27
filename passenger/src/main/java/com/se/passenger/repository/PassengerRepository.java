package com.se.passenger.repository;

import com.se.passenger.entity.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

    @Query(value = "select * from passenger where passenger_id = :passenger_id", nativeQuery = true)
    public Passenger getById(@Param(value = "passenger_id") int passenger_id);

}
