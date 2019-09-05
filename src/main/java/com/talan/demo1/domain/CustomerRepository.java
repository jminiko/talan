package com.talan.demo1.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query("select count (*) from Customer c")
    Long countCustormer();

    @Query("FROM Customer c WHERE c.firstName = :firstName")
    List<Customer> findByFirstName(@Param("firstName") String firstName);
}