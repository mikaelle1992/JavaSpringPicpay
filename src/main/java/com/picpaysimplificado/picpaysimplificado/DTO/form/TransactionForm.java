package com.picpaysimplificado.picpaysimplificado.DTO.form;

import java.math.BigDecimal;

public record TransactionForm(BigDecimal value, Long senderId, Long receiverId) {

}
