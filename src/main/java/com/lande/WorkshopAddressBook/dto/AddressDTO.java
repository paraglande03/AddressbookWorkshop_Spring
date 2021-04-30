package com.lande.WorkshopAddressBook.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressDTO {
	
	
	
	@NotBlank(message = "Address should not be empty")
	public String address;
	
	@NotBlank(message = "City should not be empty")
	public String city;
	
	@NotBlank(message = "state should not be empty")
	public String state;
	
	@Pattern(regexp = "^[0-9]{6}$" , message = "Please add valid six digit pin code")
	@NotBlank(message = "pin code should not be empty")
	public String zip;
	
	@Override
	public String toString() {
		return "AddressDTO [address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	public AddressDTO(String address, String city, String state, String zip) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	

}
