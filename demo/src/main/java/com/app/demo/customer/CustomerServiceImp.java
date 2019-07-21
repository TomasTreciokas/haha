package com.app.demo.customer;

import com.app.demo.CustomerCase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImp implements CustomerService, CustomerCaseService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private CustomerCaseRepository customerCaseRepo;

    public List <Customer> getAllCustomers(){

        return customerRepo.findAll();
    }

    @Override
    public void addCustomer(CustomerRequest customerRequest) {

        Customer customer = new Customer(customerRequest.getPersonal_id(), customerRequest.getFirstName(),
                customerRequest.getLastName(), customerRequest.getCountry());
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String personal_id) {

        customerRepo.deleteById(personal_id);
    }

    public List<CustomerResponse> getCustomersByName(String idName) {

        List <Customer> entities = customerRepo.findByLastName(idName);
        List<CustomerResponse> customerResponse = entities.stream().map(s -> makeFromEntityToCustomerResponse(s)).
                collect(Collectors.toList());

        return customerResponse;
    }

    public CustomerResponse makeFromEntityToCustomerResponse (Customer customer){

        CustomerResponse customerResponse = new CustomerResponse(customer.getPersonalId(), customer.getCountry());

        customerResponse.setCases(customer.getCases().stream().
                map(s -> new CustomerCaseResponse(s.getId(), s.getState())).collect(Collectors.toList()));

        return customerResponse;
    }

    @Override
    public void addCustomerCase(CustomerCaseRequest customerCaseRequest) {
        CustomerCase customerCase = new CustomerCase(customerCaseRequest.getDuration(), customerCaseRequest.getMonthlySalary(),
                customerCaseRequest.getWantedAmount(), customerCaseRequest.getPersonalId());
        customerCase.setState(makeDecisionOnCase(customerCase));
        customerCaseRepo.save(customerCase);
    }

    @Override
    public void deleteCustomerCaseById(Long customerCaseId) {
        customerCaseRepo.deleteById(customerCaseId);
    }

    public CaseState makeDecisionOnCase(CustomerCase customerCase){
        if(customerCase.getMonthlySalary()+300 >= (customerCase.getWantedAmount()/customerCase.getDuration())) {
            return CaseState.APPROVED;
        }
        else if(customerCase.getMonthlySalary()+300 < (customerCase.getWantedAmount()/customerCase.getDuration()))
        {
            return CaseState.REJECTED;
        }
        return CaseState.PENDING;
    }
}
