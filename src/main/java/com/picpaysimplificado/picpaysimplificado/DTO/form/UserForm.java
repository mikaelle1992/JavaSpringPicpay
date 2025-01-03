package com.picpaysimplificado.picpaysimplificado.DTO.form;

import java.math.BigDecimal;

import com.picpaysimplificado.picpaysimplificado.domain.user.Usertype;

public record UserForm(String firstName, String lastName, String cpf, 
    String email, String password, BigDecimal balance, Usertype usertype) {

}
