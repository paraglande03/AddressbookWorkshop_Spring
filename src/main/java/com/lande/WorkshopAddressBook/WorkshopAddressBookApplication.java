package com.lande.WorkshopAddressBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WorkshopAddressBookApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(WorkshopAddressBookApplication.class, args);
		log.info("AddressBook application started in {} environment", context.getEnvironment().getProperty("environment"));
		
		log.info("AddressBook user is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
