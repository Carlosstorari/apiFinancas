package com.example.apiFinancas.controller;

import com.example.apiFinancas.model.Transaction;
import com.example.apiFinancas.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> listTransaction(){
        return transactionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTransaction(@RequestBody Transaction transacao) {
        return transactionRepository.save(transacao);
    }


    @PutMapping("/update/{id}")
    public Transaction updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
        Optional<Transaction> transactionData = transactionRepository.findById(id);

        if (transactionData.isPresent()) {
            Transaction _transaction = transactionData.get();
            _transaction.setType(transaction.getType());
            _transaction.setValue(transaction.getValue());
            _transaction.setDate(transaction.getDate());
            return transactionRepository.save(_transaction);
        }
        return transaction;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable("id") long id){
        transactionRepository.deleteById(id);
    }
}
