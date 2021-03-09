package com.example.apiFinancas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntrada {
    private Long id;

    private String type;

    private Double value;

    private String date;
}
