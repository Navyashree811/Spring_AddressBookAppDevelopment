package com.bridgelabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.ContactDto;
import com.bridgelabz.dto.LoginDto;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.model.Contact;
import com.bridgelabz.model.User;
import com.bridgelabz.repository.AddressBookRepository;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.util.EmailSenderService;
import com.bridgelabz.util.JwtToken;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	EmailSenderService senderService;

	@Autowired
	JwtToken jwtToken;

	@Autowired
	private AddressBookRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public String createAddressBook(ContactDto contactDto) {

		Contact c = new Contact(contactDto);
		repository.save(c);
		senderService.sendEmail(c.getEmail(), "Test Email", "Data add Successful !" + c);
		return jwtToken.createToken(c.getId());
	}

	@Override
	public Contact updateAddressBook(int address_id, ContactDto contactDto) {

		Contact c = repository.findById(address_id);
		c.updateAddressBook(contactDto);
		return repository.save(c);
	}

	@Override
	public Contact deleteAddressBookData(int address_id) {

		Contact c = repository.deleteById(address_id);
		return c;

	}

	@Override
	public List<Contact> getAddressBookDataAscByState() {

		return repository.getAddressBookDataByStateName();
	}

	@Override
	public List<Contact> getAddressBookDataAscByCity() {

		return repository.getAddressBookDataByCityName();
	}

	@Override
	public User register(RegisterDto registerDto) {

		User u = null;
		u = new User(registerDto);
		return userRepository.save(u);
	}

	@Override
	public String login(LoginDto loginDto) {

		User u = userRepository.findByUserName(loginDto.getUserName());
		String token = null;

		if (u != null) {
			if (loginDto.getPassword().equalsIgnoreCase(u.getPassword())) {

				token = jwtToken.createToken(u.getUserId());
				System.out.println("Jwt Token : " + token);
			}

		}
		return token;
	}

	@Override
	public List<Contact> getAll(String token) {

		jwtToken.decodeJWT(token);
		List<Contact> getAllBook = repository.getAllBook();
		System.out.println("getAllBook : " + getAllBook);
		return getAllBook;

	}

}
