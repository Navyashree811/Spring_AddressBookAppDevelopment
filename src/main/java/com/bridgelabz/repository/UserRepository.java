package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {  
	
	User findByUserName(String user);
	User findByUserId(long id);
	

}
