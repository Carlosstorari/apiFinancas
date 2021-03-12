package com.example.apiFinancas.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntrada {

    private String type;

    private Double value;

    private String date;

    private Long user_id;
}
