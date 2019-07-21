package com.app.demo.CustomerCase;

public interface CustomerCaseService {

    void addCustomerCase(CustomerCaseRequest customerCaseRequest);
    void deleteCustomerCaseById(Long id);
}
