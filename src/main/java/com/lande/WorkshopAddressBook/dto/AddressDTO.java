package com.lande.WorkshopAddressBook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@ToString
public @Data class AddressDTO {
	
	@NotBlank(message = "Address should not be empty")
	public String address;
	
	@NotBlank(message = "City should not be empty")
	public String city;
	
	@NotBlank(message = "state should not be empty")
	public String state;
	
	@NotNull(message = "pin code should not be empty")
	public Long zip;
	
	@Override
	public String toString() {
		return "AddressDTO [address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	public AddressDTO(String address, String city, String state, Long zip) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	

}
