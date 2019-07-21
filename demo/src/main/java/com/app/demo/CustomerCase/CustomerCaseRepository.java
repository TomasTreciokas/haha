package com.app.demo.CustomerCase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCaseRepository extends JpaRepository<CustomerCase, Long> {

    @Query("select c from CustomerCase c where c.personal_id = ?1")
    List<CustomerCase> findByCustomerCases(String nameId);
    @Query("update CustomerCase c set c.state = ?1 where c.personalId = ?2 AND c.id = ?3")
    void changeCreditDecision(CaseState updatedCaseState, String cusotmerID, String caseId);
}
