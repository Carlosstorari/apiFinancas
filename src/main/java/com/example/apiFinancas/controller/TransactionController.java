package com.example.apiFinancas.controller;

import com.example.apiFinancas.facade.TransactionFacade;
import com.example.apiFinancas.model.TransactionEntrada;
import com.example.apiFinancas.model.TransactionSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@Configuration
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionFacade transactionFacade;

//    @GetMapping
//    public List<TransactionEntity> listTransaction() {
//        return transactionFacade.list();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<TransactionSaida> addTransaction(@RequestBody List<TransactionEntrada> transactionEntrada) {
        return transactionFacade.register(transactionEntrada);
    }


//    @PutMapping("/update/{id}")
//    public TransactionEntity updateTransaction(@PathVariable("id") long id, @RequestBody TransactionEntity transactionEntity) {
//        return transactionFacade.update(id, transactionEntity);
//    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteTransaction(@PathVariable("id") long id) {
//        transactionFacade.delete(id);
//    }
}
