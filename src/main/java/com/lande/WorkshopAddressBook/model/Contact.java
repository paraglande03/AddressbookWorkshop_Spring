package com.lande.WorkshopAddressBook.model;


import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.lande.WorkshopAddressBook.dto.ContactDTO;

import lombok.Data;


@Entity
@Table(name = "contact_details")
public @Data class Contact {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2" , strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID id;
	
	@DateTimeFormat
	@CreationTimestamp
	private LocalDateTime created_on ;
	public String first_name;
	public String last_name;
	public String email;
	public String phoneNumber;
	@UpdateTimestamp
	private LocalDateTime updated_on;
	
	public Contact() {}
	
	public Contact( ContactDTO dto) {
		super();
		
		this.first_name = dto.first_name;
		this.last_name = dto.last_name;
		this.email = dto.email;
		this.phoneNumber = dto.phoneNumber;
	}
	
}


