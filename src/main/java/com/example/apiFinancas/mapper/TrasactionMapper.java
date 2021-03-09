package com.example.apiFinancas.mapper;

import com.example.apiFinancas.model.TransactionEntity;
import com.example.apiFinancas.model.TransactionEntrada;
import com.example.apiFinancas.model.TransactionSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrasactionMapper {

    TrasactionMapper mapper = Mappers.getMapper(TrasactionMapper.class);

    TransactionEntity mapToEntity(TransactionEntrada vagaEntrada);

    TransactionSaida mapToSaida(TransactionEntity vagaEntity);

}
