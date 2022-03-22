package com.aybaroud.customer;

import com.aybaroud.customer.model.Customer;
import com.aybaroud.customer.model.CustomerRequest;
import com.aybaroud.customer.model.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudFeignClient fraudFeignClient;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

        /** RestTemplate is synchronous and blocking in nature and uses
        Java Servlet API. */
        /*  FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
           "http://localhost:8088//api/v1/fraud-check/{customerId}",
            FraudCheckResponse.class,
            customer.getId()
        );*/

        /** WebClient is asynchronous and non-blocking in nature.
        It follows events-diven architecture from reactive framework
        of Spring WebFlux.*/
         /* WebClient webClient= WebClient.create("http://localhost:8088");
        Mono<FraudCheckResponse> result =
                webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/api/v1/fraud-check/{customerId}")
                                .build(customer.getId()))
                        .retrieve()
                        .bodyToMono(FraudCheckResponse.class);
        FraudCheckResponse fraudCheckResponse = result.block();*/

        /** call to Fraud service using OpenFeign */
        FraudCheckResponse fraudCheckResponse =
                fraudFeignClient.getFraudCheck(customer.getId());

        if (fraudCheckResponse.fraudulentCustomer) {
            throw new IllegalStateException("fraudster");
        }
    }
}
