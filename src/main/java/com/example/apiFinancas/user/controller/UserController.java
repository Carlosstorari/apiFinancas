package com.example.apiFinancas.user.controller;

import com.example.apiFinancas.transaction.model.TransactionEntrada;
import com.example.apiFinancas.transaction.model.TransactionSaida;
import com.example.apiFinancas.user.facade.UserFacade;
import com.example.apiFinancas.user.model.UserEntrada;
import com.example.apiFinancas.user.model.UserSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Configuration
@CrossOrigin
public class UserController {

    @Autowired
    private UserFacade userFacade;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserSaida add(@RequestBody UserEntrada userEntrada) {
        return userFacade.register(userEntrada);
    }

    @PostMapping("/login")
    public UserSaida login(@RequestBody UserEntrada userEntrada) throws Exception {
        return userFacade.login(userEntrada);
    }

    @PostMapping("/transactions/add")
    public UserSaida registerTransaction(@RequestBody TransactionEntrada transactionEntrada) throws Exception {
        return userFacade.registerTransaction(transactionEntrada);
    }

    @GetMapping("/transactions/{id}")
    public List<TransactionSaida> getUserTransactions(@PathVariable Long id) throws Exception {
        return userFacade.getUserTransactions(id);
    }

    @DeleteMapping("/transaction/delete")
    public String deleteTransaction(@RequestParam Long user, @RequestParam Long transaction) throws Exception {
        return userFacade.deleteTransaction(user, transaction);
    }


}
