package com.example.apiFinancas.user.mapper;

import com.example.apiFinancas.transaction.model.TransactionEntity;
import com.example.apiFinancas.user.model.UserEntity;
import com.example.apiFinancas.user.model.UserEntrada;
import com.example.apiFinancas.user.model.UserSaida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    UserEntity mapToEntity(UserEntrada userEntrada);
    @Mapping(source = "transactionEntityList", target = "transactions")
    UserSaida mapToSaida(UserEntity userEntity, List<TransactionEntity> transactionEntityList);

    UserSaida mapToSaida(UserEntity userEntity);

}
