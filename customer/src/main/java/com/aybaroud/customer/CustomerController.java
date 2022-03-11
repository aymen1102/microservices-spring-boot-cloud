package com.aybaroud.customer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@Slf4j replace this statement :
private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(CustomerController.class);
 */

@RestController
@OpenAPIDefinition(info = @Info(title="Customer API"))
@Slf4j
@RequestMapping("api/v1")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    @RequestMapping("/registerCustomer")
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        //From the @Slf4j annotation we can create logs
        // without instantiation of the logger object
        log.info("Register a new customer {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
