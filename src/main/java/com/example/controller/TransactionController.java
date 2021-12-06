package com.example.controller;

import com.example.model.Transaction;
import com.example.repository.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/transactions"})
public class TransactionController {

    private static final Logger logger = LogManager.getLogger(RewardController.class);

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public List<?> getTransactions() {
        logger.info("getTransactions");
        return transactionRepository.findAll();
    }

    @PostMapping
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        logger.info(String.format("saveTransaction transactionId %s", transaction.getId()));
        return transactionRepository.save(transaction);
    }

    @GetMapping(path = {"/{transactionId}"})
    public ResponseEntity<?> getTransaction(@PathVariable Integer transactionId) {
        logger.info(String.format("getTransaction transactionId %s", transactionId));
        return transactionRepository.findById(transactionId).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{transactionId}")
    public ResponseEntity<?> updateTransaction(@PathVariable("transactionId") Integer transactionId, @RequestBody Transaction transaction) {
        logger.info(String.format("updateTransaction transactionId %s", transactionId));
        return transactionRepository.findById(transaction.getId()).map(record -> {
            record.setAmount(transaction.getAmount());
            record.setDate(transaction.getDate());
            record.setCustomer(transaction.getCustomer());
            Transaction updated = transactionRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Integer transactionId) {
        logger.info(String.format("deleteTransaction transactionId %s", transactionId));
        return transactionRepository.findById(transactionId).map(record -> {
            transactionRepository.deleteById(transactionId);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
