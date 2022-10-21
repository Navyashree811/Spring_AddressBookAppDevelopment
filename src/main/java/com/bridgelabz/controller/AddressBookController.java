package com.bridgelabz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.ContactDto;
import com.bridgelabz.dto.ResponseDto;
import com.bridgelabz.model.Contact;
import com.bridgelabz.repository.AddressBookRepository;
import com.bridgelabz.service.IAddressBookService;

@RestController
@RequestMapping("/AddressBookService")
public class AddressBookController {
	@Autowired
	IAddressBookService service;
	
	@Autowired
	AddressBookRepository addressBookRepository;
	@GetMapping(value = { "", "/", "/get" })
	public String welcomeUserToaddressBookService() {
		return "Welcome to Address Book Home";
	}
	
	@GetMapping(value = {"/getAll" })
	public List<Contact> getAllAddressBook() {
		return addressBookRepository.findAll();
	}

	@PostMapping("/create")
	public Contact add(@RequestBody ContactDto con) {
		Contact c = null;
		c = service.createAddressBook(con);
		return c;
	}
	
	@PutMapping("/Update/{personId}")
	public Contact update(@PathVariable("personId") int personId, @RequestBody ContactDto con) {  
		Contact c = null;
		c = service.updateAddressBook(personId, con);
		return c;
		
	}
	@DeleteMapping("/delete/{personId}")
	public Integer deleteAddressBook(@PathVariable("personId") int personId) {
		return addressBookRepository.deleteAdressBook(personId) ;
	}
}
