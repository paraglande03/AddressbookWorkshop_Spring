package com.lande.WorkshopAddressBook.dto;

import lombok.Data;

public @Data class ContactDTO {
	public String fName;
	public String lName;
	public String email;
	public Long phoneNumber;
	
	
	@Override
	public String toString() {
		return "ContactDTO [fName=" + fName + ", lName=" + lName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}


	public ContactDTO(String fName, String lName, String email, Long phoneNumber) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public ContactDTO() {
		
	}
}
