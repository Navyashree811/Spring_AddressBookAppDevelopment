package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.dto.ContactDto;
import com.bridgelabz.dto.LoginDto;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.model.Contact;
import com.bridgelabz.model.User;

public interface IAddressBookService {  
	Contact createAddressBook(ContactDto contactDto);
	Contact updateAddressBook(int personId, ContactDto contactDto);
 
	Contact deleteAddressBookData(int address_id);
	
	List<Contact> getAddressBookDataAscByCity();
	List<Contact> getAddressBookDataAscByState();
	
	User register(RegisterDto registerDto);
	
	User login(LoginDto loginDto);

}
