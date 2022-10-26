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
import org.springframework.web.bind.annotation.RequestHeader;
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

//	@GetMapping(value = {"/getAll" })
//	public List<Contact> getAllAddressBook() {
//		return addressBookRepository.findAll();
//	}

	@GetMapping(value = { "/getAll" })
	public List<Contact> getAllAddressBook(@RequestHeader("token") String token) {
		return service.getAll(token);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> add(@RequestBody ContactDto con) {
		String c = null;
		c = service.createAddressBook(con);
		ResponseDto responseDto = new ResponseDto("Create AddressBook Successful !", c);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/Update/{personId}")
	public ResponseEntity<ResponseDto> update(@PathVariable("personId") int personId, @RequestBody ContactDto con) {
		Contact c = null;
		c = service.updateAddressBook(personId, con);
		ResponseDto responseDto = new ResponseDto("Update AddressBook Successful !", c);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<ResponseDto> deleteAddressBook(@PathVariable("personId") int personId) {
		Contact c = null;
		c = service.deleteAddressBookData(personId);
		ResponseDto responseDto = new ResponseDto("Delete Data Successfull !", c);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}

	@GetMapping("/getByCity")
	public ResponseEntity<ResponseDto> getAddressBookDataAscByCity() {
		List<Contact> c = null;
		c = service.getAddressBookDataAscByCity();
		ResponseDto responseDto = new ResponseDto("Get City Data in Asc Successfull !", c);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}

	@GetMapping("/getByState")
	public ResponseEntity<ResponseDto> getAddressBookDataAscByState() {
		List<Contact> c = null;
		c = service.getAddressBookDataAscByState();
		ResponseDto responseDto = new ResponseDto("Get State Data in Asc Successfull !", c);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}
}
