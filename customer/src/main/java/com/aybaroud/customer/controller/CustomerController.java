package com.aybaroud.customer.controller;

import com.aybaroud.customer.model.CustomerRequest;
import com.aybaroud.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@Slf4j replace this statement : private static final org.slf4j.Logger log =
org.slf4j.LoggerFactory.getLogger(CustomerController.class);*/
@Slf4j
@RestController
@RequestMapping("api/v1")
public record CustomerController(CustomerService customerService) {

    @PostMapping("/registerCustomer")
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("Register a new customer {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }

}
