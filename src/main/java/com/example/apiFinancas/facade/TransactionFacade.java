package com.example.apiFinancas.facade;

import com.example.apiFinancas.mapper.TrasactionMapper;
import com.example.apiFinancas.model.TransactionEntity;
import com.example.apiFinancas.model.TransactionEntrada;
import com.example.apiFinancas.model.TransactionSaida;
import com.example.apiFinancas.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TransactionFacade {

    @Autowired
    private TransactionRepository transactionRepository;

    TrasactionMapper mapper = Mappers.getMapper(TrasactionMapper.class);

    public List<TransactionSaida> register(List<TransactionEntrada> transactionEntrada){
        List<TransactionEntity> transactionEntities = new ArrayList<>();
        List<TransactionSaida> transactionSaidas = new ArrayList<>();
        for (TransactionEntrada transactionsEntrada : transactionEntrada) {
            transactionEntities.add(mapper.mapToEntity(transactionsEntrada));
        }

        transactionEntities = transactionRepository.saveAll(transactionEntities);
        for (TransactionEntity transactionEntity : transactionEntities) {
            transactionSaidas.add(mapper.mapToSaida(transactionEntity));
        }
        return transactionSaidas;
    }

//    public List<TransactionEntity> list(){
//        return transactionRepository.findAll();
//    }

//    public TransactionEntity update(Long id, TransactionEntity transactionEntity){
//        Optional<TransactionEntity> transactionData = transactionRepository.findById(id);
//
//        if (transactionData.isPresent()) {
//            TransactionEntity _transactionEntity = transactionData.get();
//            _transactionEntity.setType(transactionEntity.getType());
//            _transactionEntity.setValue(transactionEntity.getValue());
//            _transactionEntity.setDate(transactionEntity.getDate());
//            return transactionRepository.save(_transactionEntity);
//        }
//        return transactionEntity;
//    }


//    public void delete(Long id){
//        transactionRepository.deleteById(id);
//    }
}
