package com.picpaysimplificado.picpaysimplificado.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.user.Usertype;
import com.picpaysimplificado.picpaysimplificado.infra.exception.*;
import com.picpaysimplificado.picpaysimplificado.repositories.UserRepository;

@Service 
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) {
        if (sender.getUsertype() == Usertype.MERCHAN) {
            throw new UnauthorizedTransactionException("Usuário não está autorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Usuário não tem saldo suficiente");
        }
    }

    public User findUserById(Long id){
        return repository.findUserById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado, id: " + id));
   }

   public void saveUser(User user){
        this.repository.save(user);
   }

}
