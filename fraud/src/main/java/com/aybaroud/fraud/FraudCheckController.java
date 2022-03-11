package com.aybaroud.fraud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@OpenAPIDefinition(info = @Info(title="Fraud API"))
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckController {

    @Autowired
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFrauduster(@PathVariable Integer customerId){
        boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulentCustomer);
    }

}
