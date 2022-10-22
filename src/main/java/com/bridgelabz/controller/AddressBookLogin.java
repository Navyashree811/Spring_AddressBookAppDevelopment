package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.ContactDto;
import com.bridgelabz.dto.LoginDto;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.dto.ResponseDto;
import com.bridgelabz.model.Contact;
import com.bridgelabz.model.User;
import com.bridgelabz.service.IAddressBookService;

@RestController
@RequestMapping("/userService")
public class AddressBookLogin {

	@Autowired IAddressBookService service;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDto> add(@RequestBody RegisterDto  registerDto) {
		User u = null;
		u = service.register(registerDto);
		ResponseDto responseDto = new ResponseDto("Registration Successful !", u);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDto> login(@RequestBody LoginDto  loginDto) {
		
		User u = null;
		u = service.login(loginDto);
		if(u != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Login Successful !",  u.getUserName()).body(new ResponseDto("Login SuccessFul !", u.getEmaild()));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Login failed", null));
		}
	}
}
