package com.example.apiFinancas.controller;

import com.example.apiFinancas.model.Transacao;
import com.example.apiFinancas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public List<Transacao> listar(){
        return transacaoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao adicionar(@RequestBody Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
}
