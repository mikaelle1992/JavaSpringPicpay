package com.picpaysimplificado.picpaysimplificado.service;


import java.time.LocalDateTime;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.picpaysimplificado.DTO.form.TransactionForm;
import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.infra.exception.NotAuthorizeTransactionException;
import com.picpaysimplificado.picpaysimplificado.repositories.TransactionRepository;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;
    
    public Transaction createTransaction(TransactionForm transactionForm){

        User sender = this.userService.findUserById(transactionForm.senderId());
        User receiver = this.userService.findUserById(transactionForm.receiverId());

        userService.validateTransaction(sender, transactionForm.value());
        boolean isAuthorize = this.authorizeTransaction();
        if(!isAuthorize){
            throw new NotAuthorizeTransactionException("Usuário não autorizado");
        }
        Transaction transactionNew = new Transaction();
        transactionNew.setAmount(transactionForm.value());
        transactionNew.setReceiver(receiver);
        transactionNew.setSender(sender);
        transactionNew.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transactionForm.value()));
        receiver.setBalance(receiver.getBalance().add(transactionForm.value()));

        this.repository.save(transactionNew);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Transação realizado com sucesso");
        this.notificationService.sendNotification(receiver, "Transação recebida com sucesso");

        return transactionNew;
    }


    public boolean authorizeTransaction() {
        ResponseEntity<Map> response = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
    
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> body = response.getBody();
            if (body != null && body.get("status").equals("success")) {
                Map<String, Object> data = (Map<String, Object>) body.get("data");
                if (data != null && Boolean.TRUE.equals(data.get("authorization"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
