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

import com.lande.WorkshopAddressBook.dto.AddressDTO;

import lombok.Data;

@Entity
@Table(name = "address_details")
public @Data class Address {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2" , strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID id;
	
	
	@CreationTimestamp
	private LocalDateTime created_on ;
	public String address;
	public String city;
	public String state;
	public String zip;
	
	@UpdateTimestamp
	private LocalDateTime updated_on;
	

	public Address( AddressDTO dto) {
		super();
		
		this.address = dto.address;
		this.city = dto.city;
		this.state = dto.state;
		this.zip = dto.zip;
		
	}
	public Address() {}
	
	
	
	
	

}
