package com.app.demo.CustomerCase;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personal_id;
    private Integer duration;
    private Double monthlySalary;
    private Double wantedAmount;
    private CaseState state;
    //private java.sql.Date currentDate;

    public CustomerCase(){}

    @Autowired
    public CustomerCase(Integer duration, Double monthlySalary, Double wantedAmount, String personal_id){
        this.duration = duration;
        this.monthlySalary = monthlySalary;
        this.wantedAmount = wantedAmount;
        this.personal_id = personal_id;
       // this.currentDate = java.sql.Date.valueOf(new Date().toString());
    }
    /*
    public java.sql.Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(java.sql.Date currentDate) {
        this.currentDate = currentDate;
    }*/
    public CaseState getState() {
        return state;
    }

    public void setState(CaseState state) {
        this.state = state;
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
