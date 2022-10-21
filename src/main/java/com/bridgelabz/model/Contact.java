package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.dto.ContactDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addressbook_db")
public class Contact {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "address_id")
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int pincode;
	private String email;
	private long phoneNumber;
	
	public Contact(ContactDto contactDto) {
		this.firstName = contactDto.firstName;
		this.lastName = contactDto.lastName;
		this.email = contactDto.email;
		this.address = contactDto.address;
		this.city= contactDto.city;
		this.state = contactDto.state;
		this.pincode = contactDto.pincode;
		this.phoneNumber = contactDto.phoneNumber;
	}

	public void updateAddressBook(ContactDto contactDto) {

		this.firstName = contactDto.firstName;
		this.lastName = contactDto.lastName;
		this.email = contactDto.email;
		this.address = contactDto.address;
		this.city= contactDto.city;
		this.state = contactDto.state;
		this.pincode = contactDto.pincode;
		this.phoneNumber = contactDto.phoneNumber;
	}
	

	
}
