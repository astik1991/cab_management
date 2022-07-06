package com.phonepe.controller;

import com.phonepe.model.Customer;
import com.phonepe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
    private String registerCustomerDetails(@RequestBody Customer cabDetails) {
        return iCustomerService.registerCustomerDetails(cabDetails);
    }
}
