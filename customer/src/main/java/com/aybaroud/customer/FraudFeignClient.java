package com.aybaroud.customer;

import com.aybaroud.customer.model.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/** Annotation for interfaces declaring that a REST client with that interface should be created */
@FeignClient(name = "fraud")
public interface FraudFeignClient {

    @GetMapping("/api/v1/fraud-check/{customerId}")
    FraudCheckResponse getFraudCheck(@PathVariable("customerId") int customerId);

}
