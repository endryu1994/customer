package com.akybenko.customer.controller;

import static com.akybenko.customer.constant.ApiPath.API_CUSTOMER_PATH;
import static com.akybenko.customer.constant.ApiPath.UUID;
import static com.akybenko.customer.constant.ApiPath.UUID_PATH;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(API_CUSTOMER_PATH)
@RequiredArgsConstructor
public class CustomerController implements CustomerControllerApi {

    private final CustomerService customerService;

    @GetMapping(UUID_PATH)
    public ResponseEntity<CustomerDtoGenerated> findById(@PathVariable(UUID) UUID customerId) {
        CustomerDtoGenerated customer = customerService.findById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerDtoGenerated> create(@Valid @RequestBody CustomerDtoGenerated dto) {
        CustomerDtoGenerated customer = customerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @DeleteMapping(UUID_PATH)
    public ResponseEntity<Void> deleteById(@PathVariable(UUID) UUID customerId) {
        customerService.deleteById(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
