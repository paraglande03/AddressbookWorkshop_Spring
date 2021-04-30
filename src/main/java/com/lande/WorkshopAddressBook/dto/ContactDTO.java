package com.lande.WorkshopAddressBook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;


public @Data class ContactDTO {
	
	@Pattern(regexp = "^[a-zA-Z]{2,}$" , message = "Please add valid first name")
	@NotBlank(message = "name should not be empty")
	public String first_name;
	
	@Pattern(regexp = "^[a-zA-Z]{2,}$" , message = "Please add valid last name")
	@NotBlank(message = "name should not be empty")
	public String last_name;
	
	
	@Email
	@NotBlank(message = "email should not be empty")
	public String email;
	
	@NotBlank(message = "Phone number should not be empty")
	@Pattern(regexp = "^[0-9]{10}$" , message = "Please valid 10 digit phone number")
	public String phoneNumber;
	
	
	@Override
	public String toString() {
		return "ContactDTO [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}


	public ContactDTO(String first_name, String last_name, String email, String phoneNumber) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public ContactDTO() {
		
	}
}
