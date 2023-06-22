package com.ltp.contacts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class Application implements CommandLineRunner {

	ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Cryptography - Bycrypt = hash algorithm
	// One way hash
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		contactRepository.getContacts().add(new Contact("1", "Jon Snow", "6123456432"));
		contactRepository.getContacts().add(new Contact("2", "Tyrion Lannister", "3125466472"));
		contactRepository.getContacts().add(new Contact("3", "The Hound", "5126476532"));		
	}

}
