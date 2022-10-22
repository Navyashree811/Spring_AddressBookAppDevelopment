package com.bridgelabz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.dto.RegisterDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class User {  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String userName;
	private String emaild;
	private String password;
	
	public User(RegisterDto dto) {
		this.userName = dto.userName;
		this.emaild = dto.emaild;
		this.password = dto.password;
	}
	
	
	

}
