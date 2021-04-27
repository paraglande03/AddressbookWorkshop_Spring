package com.lande.WorkshopAddressBook.dto;

import lombok.Data;

public @Data class AddressDTO {
	public String address;
	public String city;
	public String state;
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
