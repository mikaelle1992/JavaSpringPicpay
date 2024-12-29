package com.picpaysimplificado.picpaysimplificado.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.picpaysimplificado.DTO.form.TransactionForm;
import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.repositories.TransactionRepository;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    public void createTransaction(TransactionForm transactionForm){

        User sender = this.userService.findUserById(transactionForm.senderId());
        User receiver = this.userService.findUserById(transactionForm.receiverId());

        userService.validateTransaction(sender, transactionForm.value());


    }
}
