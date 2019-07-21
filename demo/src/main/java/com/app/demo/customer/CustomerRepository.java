package com.app.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>
{

    @Query("select c from Customer c where c.personalId = ?1")
    List<Customer> findByLastName(String name);

}
