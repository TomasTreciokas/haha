package com.app.demo.CustomerCase;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CustomerCaseRequest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personal_id;
    private Integer duration;
    private Double monthlySalary;
    private Double wantedAmount;


    public CustomerCaseRequest(){}

    @Autowired
    public CustomerCaseRequest(Integer duration, Double monthlySalary, Double wantedAmount, String personal_id){
        this.duration = duration;
        this.monthlySalary = monthlySalary;
        this.wantedAmount = wantedAmount;
        this.personal_id = personal_id;
    }

    public String getPersonalId() {
        return personal_id;
    }

    public void setPersonalId(String personal_id) {
        this.personal_id = personal_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long case_id) {
        this.id = case_id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Double getWantedAmount() {
        return wantedAmount;
    }

    public void setWantedAmount(Double wantedAmount) {
        this.wantedAmount = wantedAmount;
    }

}
