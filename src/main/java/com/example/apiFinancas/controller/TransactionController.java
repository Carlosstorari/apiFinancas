package com.example.apiFinancas.controller;

import com.example.apiFinancas.facade.TransactionFacade;
import com.example.apiFinancas.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionFacade transactionFacade;

    @GetMapping
    public List<Transaction> listTransaction() {
        return transactionFacade.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionFacade.register(transaction);
    }


    @PutMapping("/update/{id}")
    public Transaction updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
        return transactionFacade.update(id, transaction);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable("id") long id) {
        transactionFacade.delete(id);
    }
}
