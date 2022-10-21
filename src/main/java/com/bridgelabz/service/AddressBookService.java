package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.ContactDto;
import com.bridgelabz.model.Contact;
import com.bridgelabz.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService{

	@Autowired
	private AddressBookRepository repository;
	
	@Override
	public Contact createAddressBook(ContactDto contactDto) {

		Contact c = null;
		c = new Contact(contactDto);
		return repository.save(c);
	}

	@Override
	public Contact updateAddressBook(int address_id, ContactDto contactDto) {
        
		Contact c = repository.findById(address_id);
		c.updateAddressBook(contactDto);
		return repository.save(c);
	}

}
