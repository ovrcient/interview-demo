package com.example.service;

import com.example.model.Customer;
import com.example.model.Transaction;
import com.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RewardService {
    private final CustomerRepository customerRepository;

    public RewardService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Integer getRewards(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        int rewards = 0;
        // TODO, reduce with stream..
        if (customer.isPresent()) {
            for (Transaction transaction : customer.get().getTransactions()) rewards += transaction.getPoints();
        }
        return rewards;
    }
}
