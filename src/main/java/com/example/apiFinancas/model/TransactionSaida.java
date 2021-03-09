package com.example.apiFinancas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionSaida {

    private Long id;

    private String type;

    private Double value;

    private String date;

}
