package com.picpaysimplificado.picpaysimplificado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaysimplificado.picpaysimplificado.DTO.form.TransactionForm;
import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.service.TransactionService;

@RestController()
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionForm Transaction){
        Transaction newTransaction = service.createTransaction(Transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
