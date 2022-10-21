package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
	public String firstName;
	public String lastName;
	public String email;
	public String address;
	public String city;
	public String state;
	public int pincode;
	public long phoneNumber;
	

}
