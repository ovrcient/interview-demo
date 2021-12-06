package com.example.controller;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping({"/customers"})
public class CustomerController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<?> getCustomers() {
        logger.info("getCustomers");
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        logger.info(String.format("saveCustomer customerId %s", customer.getId()));
        return customerRepository.save(customer);
    }

    @GetMapping(path = {"/{customerId}"})
    public ResponseEntity<?> getCustomer(@PathVariable Integer customerId) {
        logger.info(String.format("getCustomer customerId %s", customerId));
        return customerRepository.findById(customerId).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer) {
        logger.info(String.format("updateCustomer customerId %s", customerId));
        // TODO, handling Transactions in Customer..
        return customerRepository.findById(customer.getId()).map(record -> {
            record.setName(customer.getName());
            record.setTransactions(customer.getTransactions());
            Customer updated = customerRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        logger.info(String.format("deleteCustomer customerId %s", customerId));
        return customerRepository.findById(customerId).map(record -> {
            customerRepository.deleteById(customerId);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
