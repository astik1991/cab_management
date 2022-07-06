package com.phonepe.service.impl;

import com.phonepe.model.Customer;
import com.phonepe.repository.CustomerRepository;
import com.phonepe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String registerCustomerDetails(Customer customer){
        Customer saveCustomerData = customerRepository.save(customer);
        return saveCustomerData!=null?"Successfully Save Customer Data " : "Customer Data is not valid !!!";
    }

}
