package com.picpaysimplificado.picpaysimplificado.domain.user;

import java.math.BigDecimal;

import com.picpaysimplificado.picpaysimplificado.DTO.form.UserForm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String cpf;
	@Column(unique=true)
	private String email;
	private String password;
	private BigDecimal balance;
	@Enumerated(EnumType.STRING)
	private Usertype usertype;
	
	public User(UserForm data) {
		this.firstName=data.firstName();
		this.lastName=data.lastName();
		this.cpf=data.cpf();
		this.email=data.email();
		this.password=data.password();
		this.balance=data.balance();
		this.usertype= data.usertype();
	}
}
