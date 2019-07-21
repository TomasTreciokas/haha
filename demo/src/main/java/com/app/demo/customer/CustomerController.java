package com.app.demo.customer;


import com.app.demo.CustomerCase.CustomerCaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImp service;

    @GetMapping(params={"personal_id"})
    public List<CustomerResponse> getCustomersByName(@RequestParam("personal_id") String name){

            return service.getCustomersByName(name);

    }
    //Create customer
    @PostMapping
    public CustomerRequest createCustomer(@RequestBody CustomerRequest customerRequest) {
        service.addCustomer(customerRequest);
        return customerRequest;
    }
    //create customer case
    @PostMapping("/cases")
    public CustomerCaseRequest createCase(@RequestBody CustomerCaseRequest customerCaseRequest)
    {
        service.addCustomerCase(customerCaseRequest);
        return customerCaseRequest;
    }
    //delete customer and cases related to him
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id)
    {
        service.deleteCustomer(id);
    }
    //delete customer case
    @DeleteMapping("/cases/{personalId}/{caseId}")
    public void deleteCustomerCase(@PathVariable("personalId") String personalId, @PathVariable("caseId") Long caseId){

        service.deleteCustomerCaseById(caseId);
    }



}