package com.example.apiFinancas.transaction.controller;

import com.example.apiFinancas.transaction.facade.TransactionFacade;
import com.example.apiFinancas.transaction.model.TransactionEntity;
import com.example.apiFinancas.transaction.model.TransactionEntrada;
import com.example.apiFinancas.transaction.model.TransactionSaida;
import com.example.apiFinancas.user.model.UserSaida;
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

    @GetMapping
    public List<TransactionSaida> listTransaction() {
        return transactionFacade.list();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public TransactionEntity add(@RequestBody TransactionEntrada transactionEntrada) throws Exception {
//        return transactionFacade.register(transactionEntrada);
//    }


    @PutMapping("/update/{id}")
    public TransactionSaida update(@PathVariable("id") long id, @RequestBody TransactionEntrada transactionEntrada) throws Exception {
        return transactionFacade.update(id, transactionEntrada);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return transactionFacade.delete(id);
    }
}
