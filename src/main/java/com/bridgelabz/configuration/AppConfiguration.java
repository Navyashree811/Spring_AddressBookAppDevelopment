package com.bridgelabz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.util.EmailSenderService;
import com.bridgelabz.util.JwtToken;

@Configuration
public class AppConfiguration {
	@Bean
	public JwtToken jwttoken() {
		return new JwtToken();
	}

	@Bean
	public EmailSenderService emailSenderService() {
		return new EmailSenderService();
	}

}
