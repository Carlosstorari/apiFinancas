package com.example.apiFinancas.user.model;

import com.example.apiFinancas.transaction.model.TransactionSaida;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserSaida {

    private Long id;

    private String email;

    List<TransactionSaida> transactions = new ArrayList<>();

}
