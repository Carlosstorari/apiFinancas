package com.example.apiFinancas.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Double value;
    private String date;

}
