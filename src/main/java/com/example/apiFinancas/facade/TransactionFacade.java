package com.example.apiFinancas.facade;

import com.example.apiFinancas.model.Transaction;
import com.example.apiFinancas.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionFacade {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction register(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> list(){
        return transactionRepository.findAll();
    }

    public Transaction update(Long id, Transaction transaction){
        Optional<Transaction> transactionData = transactionRepository.findById(id);

        if (transactionData.isPresent()) {
            Transaction _transaction = transactionData.get();
            _transaction.setType(transaction.getType());
            _transaction.setValue(transaction.getValue());
            _transaction.setDate(transaction.getDate());
            return transactionRepository.save(_transaction);
        }
        return transaction;
    }


    public void delete(Long id){
        transactionRepository.deleteById(id);
    }
}
