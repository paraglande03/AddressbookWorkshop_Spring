package com.lande.WorkshopAddressBook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@ToString
public @Data class ContactDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$" , message = "Please add valid first name")
	public String fName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$" , message = "Please add valid last name")
	public String lName;
	
	@NotBlank(message = "Please add email")
	public String email;
	
	@NotBlank(message = "please add phone number")
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
