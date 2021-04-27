package com.lande.WorkshopAddressBook.dto;

public class AddressDTO {
	public String address;
	public String city;
	public String state;
	public long zip;
	
	@Override
	public String toString() {
		return "AddressDTO [address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	public AddressDTO(String address, String city, String state, long zip) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	

}
