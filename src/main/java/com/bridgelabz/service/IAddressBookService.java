package com.bridgelabz.service;

import com.bridgelabz.dto.ContactDto;
import com.bridgelabz.model.Contact;

public interface IAddressBookService {  
	Contact createAddressBook(ContactDto contactDto);
	Contact updateAddressBook(int personId, ContactDto contactDto);

}
