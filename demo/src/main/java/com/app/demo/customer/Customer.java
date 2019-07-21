package com.app.demo.customer;

import com.app.demo.CustomerCase.CustomerCase;

import javax.persistence.*;
import java.util.List;


@Entity
public class Customer {

    @Id
    @Column(name = "personal_id")
    private String personalId;
    private String firstName;
    private String lastName;
    private String country;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id", referencedColumnName = "personal_id")
    private List<CustomerCase> cases;

    public Customer(){}

    public Customer(String personalId, String firstName, String lastName, String country){
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;

    }

    public List<CustomerCase> getCases() {
        return cases;
    }

    public void setCases(List<CustomerCase> cases) {
        this.cases = cases;
    }


    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personal_id) {
        this.personalId = personal_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}