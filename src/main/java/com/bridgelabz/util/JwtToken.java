package com.bridgelabz.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bridgelabz.repository.UserRepository;

public class JwtToken {
	@Autowired
	UserRepository repository;

	private static final String SECRET = "Navya";

	public String createToken(int empId) {
		String token = JWT.create().withClaim("id", empId).sign(Algorithm.HMAC256(SECRET));
		return token;
	}

	public int decodeJWT(String jwt) {

		int id = 0;
		if (jwt != null) {

			id = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(jwt).getClaim("id").asInt();
		}
		return id;
	}
}