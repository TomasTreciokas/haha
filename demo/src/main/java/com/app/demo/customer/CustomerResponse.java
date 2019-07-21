package com.app.demo.customer;

import com.app.demo.CustomerCase.CustomerCaseResponse;

import java.util.List;

public class CustomerResponse {
    private String identityNr;

    private String country;
    private List<CustomerCaseResponse> cases;

    public CustomerResponse(String identityNr, String country){
        this.identityNr = identityNr;
        this.country = country;
    }

    public String getIdentityNr() {
        return identityNr;
    }

    public void setIdentityNr(String identityNr) {
        this.identityNr = identityNr;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CustomerCaseResponse> getCases() {
        return cases;
    }

    public void setCases(List<CustomerCaseResponse> cases) {
        this.cases = cases;
    }



}
