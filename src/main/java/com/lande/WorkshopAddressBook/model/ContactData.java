package com.lande.WorkshopAddressBook.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lande.WorkshopAddressBook.dto.ContactDTO;

import lombok.Data;


@Entity
@Table(name = "contact_details")
public @Data class ContactData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	public int id;
	
	public String fName;
	public String lName;
	public String email;
	public Long phoneNumber;
	
	public ContactData() {}
	
	public ContactData( ContactDTO dto) {
		super();
		
		this.fName = dto.fName;
		this.lName = dto.lName;
		this.email = dto.email;
		this.phoneNumber = dto.phoneNumber;
	}
	
}
