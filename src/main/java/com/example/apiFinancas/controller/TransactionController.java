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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<TransactionSaida> listTransaction() {
        return transactionFacade.list();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionSaida add(@RequestBody TransactionEntrada transactionEntrada) {
        return transactionFacade.register(transactionEntrada);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update/{id}")
    public TransactionSaida update(@PathVariable("id") long id, @RequestBody TransactionEntrada transactionEntrada) throws Exception {
        return transactionFacade.update(id, transactionEntrada);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return transactionFacade.delete(id);
    }
}
