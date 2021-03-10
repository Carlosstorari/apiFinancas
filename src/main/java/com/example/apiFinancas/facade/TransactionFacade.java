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
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class TransactionFacade {

    @Autowired
    private TransactionRepository transactionRepository;

    TrasactionMapper mapper = Mappers.getMapper(TrasactionMapper.class);

    public TransactionSaida register(TransactionEntrada transactionEntrada){
        return mapper.mapToSaida(transactionRepository.save(mapper.mapToEntity(transactionEntrada)));
    }

    public List<TransactionSaida> list(){
        List<TransactionEntity> transactionEntityList = transactionRepository.findAll();
        List<TransactionSaida> transactionSaidaList = new ArrayList<>();
        for (TransactionEntity transactionEntity : transactionEntityList) {
            transactionSaidaList.add(mapper.mapToSaida(transactionEntity));
        }
        return transactionSaidaList;
    }

    public TransactionSaida update(Long id, TransactionEntrada transactionEntrada) throws Exception {
        Optional<TransactionEntity> transactionData = transactionRepository.findById(id);
        TransactionEntity _transactionEntity = transactionData.get();

        if (!transactionData.isPresent()) {
            throw new Exception("Não foi encontrada a transação.");
        }
        _transactionEntity.setType(transactionEntrada.getType());
        _transactionEntity.setValue(transactionEntrada.getValue());
        _transactionEntity.setDate(transactionEntrada.getDate());
        return mapper.mapToSaida(transactionRepository.save(_transactionEntity));
    }


    public String delete(Long id){
        transactionRepository.deleteById(id);
        return "Transação deletada com sucesso";
    }
}
