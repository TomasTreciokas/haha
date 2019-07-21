package com.app.demo.customer;

public interface CustomerService {
    void addCustomer(CustomerRequest customerRequest);
    void deleteCustomer(String personal_id);
}
