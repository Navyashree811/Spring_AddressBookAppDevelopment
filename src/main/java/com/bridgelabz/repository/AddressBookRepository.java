package com.bridgelabz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.model.Contact;

public interface AddressBookRepository extends JpaRepository<Contact, Integer> {

	
//	@Transactional
//	@Modifying
//	@Query(value = "delete from addressbook_db where address_id = :id", nativeQuery = true)
//	Integer deleteAdressBook(int id);

	public Contact deleteById(int id);
	
	public Contact findById(int id);
	
	@Query(value = "select * from addressbook_db order by city ASC", nativeQuery = true)
	List<Contact> getAddressBookDataByCityName();
	
	@Query(value = "select * from addressbook_db order by state ASC", nativeQuery = true)
	List<Contact> getAddressBookDataByStateName();

}
