package com.lande.WorkshopAddressBook.model;


import com.lande.WorkshopAddressBook.dto.ContactDTO;

import lombok.Data;


public @Data class ContactData {
	
	public int id;
	public String fName;
	public String lName;
	public String email;
	public Long phoneNumber;
	
	public ContactData() {}
	
	public ContactData(int id, ContactDTO dto) {
		super();
		this.id = id;
		this.fName = dto.fName;
		this.lName = dto.lName;
		this.email = dto.email;
		this.phoneNumber = dto.phoneNumber;
	}
	
}
