package com.example.apiFinancas.user.facade;

import com.example.apiFinancas.transaction.facade.TransactionFacade;
import com.example.apiFinancas.transaction.model.TransactionEntity;
import com.example.apiFinancas.transaction.model.TransactionEntrada;
import com.example.apiFinancas.transaction.model.TransactionSaida;
import com.example.apiFinancas.transaction.repository.TransactionRepository;
import com.example.apiFinancas.user.mapper.UserMapper;
import com.example.apiFinancas.user.model.UserEntity;
import com.example.apiFinancas.user.model.UserEntrada;
import com.example.apiFinancas.user.model.UserSaida;
import com.example.apiFinancas.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserFacade {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionFacade transactionFacade;

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public UserSaida register(UserEntrada userEntrada) {
        return mapper.mapToSaida(userRepository.save(mapper.mapToEntity(userEntrada)));
    }

    public UserSaida registerTransaction(TransactionEntrada transactionEntrada) throws Exception {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(transactionEntrada.getUser_id());
        if (!optionalUserEntity.isPresent())
            throw new Exception("Não encontrado");
        UserEntity userEntity = optionalUserEntity.get();
        List<TransactionEntity> transactionEntityList = userEntity.getTransactions();
        transactionEntityList.add(transactionFacade.register(transactionEntrada));
        userEntity.setTransactions(transactionEntityList);
        return mapper.mapToSaida(userRepository.save(userEntity));
    }

    public String deleteTransaction(Long user, Long transaction) throws Exception {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(user);
        if (!optionalUserEntity.isPresent())
            throw new Exception("Usuário não encontrado");
        UserEntity userEntity = optionalUserEntity.get();
        List<TransactionEntity> transactionEntityList = userEntity.getTransactions();
        for (TransactionEntity transactionEntity : transactionEntityList
        ) {
            if (transactionEntity.getId() == transaction) {
                userEntity.getTransactions().remove(transactionEntity);
                break;
            }
        }
        mapper.mapToSaida(userRepository.save(userEntity));
        return "Transação deletada com sucesso!";
    }

    public UserSaida login(UserEntrada userEntrada) throws Exception {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmailAndSenha(userEntrada.getEmail(), userEntrada.getSenha());
        if (!optionalUserEntity.isPresent())
            throw new Exception("Credenciais inválidas");
        UserEntity userEntity = optionalUserEntity.get();
        return mapper.mapToSaida(userEntity);
    }

    public List<TransactionSaida> getUserTransactions(Long id) throws Exception {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (!optionalUserEntity.isPresent())
            throw new Exception("Id inválido");
        UserEntity userEntity = optionalUserEntity.get();
        return mapper.mapToSaida(userEntity, userEntity.getTransactions()).getTransactions();
    }
}
