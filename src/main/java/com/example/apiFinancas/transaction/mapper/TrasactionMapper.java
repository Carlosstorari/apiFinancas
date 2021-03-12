package com.example.apiFinancas.transaction.mapper;

import com.example.apiFinancas.transaction.model.TransactionEntity;
import com.example.apiFinancas.transaction.model.TransactionEntrada;
import com.example.apiFinancas.transaction.model.TransactionSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TrasactionMapper {

    TrasactionMapper mapper = Mappers.getMapper(TrasactionMapper.class);

    TransactionEntity mapToEntity(TransactionEntrada transactionEntrada);

    TransactionSaida mapToSaida(TransactionEntity transactionEntity);


}
