package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.model.Contact;

public interface AddressBookRepository extends JpaRepository<Contact, Integer> {

	
	@Transactional
	@Modifying
	@Query(value = "delete from addressbook_db where address_id = :id", nativeQuery = true)
	Integer deleteAdressBook(int id);

	public Contact findById(int id);

}
