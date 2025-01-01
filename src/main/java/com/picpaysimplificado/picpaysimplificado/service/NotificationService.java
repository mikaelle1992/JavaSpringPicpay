package com.picpaysimplificado.picpaysimplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.picpaysimplificado.DTO.form.NotificationForm;
import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.infra.exception.NotificationException;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;


    public void sendNotification(User user, String message){
        String email = user.getEmail();
        NotificationForm notificationRequest = new NotificationForm(email, message);

       ResponseEntity<String> response = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);
       
       if(!(response.getStatusCode() == HttpStatus.OK)){
            throw new NotificationException("Serviço de notificação está fora do ar");
       }
    }



}
