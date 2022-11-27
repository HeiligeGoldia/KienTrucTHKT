package com.se.billing.repository;

import com.se.billing.entity.Billing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends CrudRepository<Billing, Integer> {

    @Query(value = "select * from billing where bill_id = :bill_id", nativeQuery = true)
    public Billing getById(@Param(value = "bill_id") int bill_id);

}
