package com.lande.WorkshopAddressBook.model;

import com.lande.WorkshopAddressBook.dto.AddressDTO;

import lombok.Data;

public @Data class AddressData {
	public int id;
	public String address;
	public String city;
	public String state;
	public long zip;
	public AddressData(int id , AddressDTO dto) {
		super();
		this.id=id;
		this.address = dto.address;
		this.city = dto.city;
		this.state = dto.state;
		this.zip = dto.zip;
	}
	public AddressData() {}
	
	
	
	

}
