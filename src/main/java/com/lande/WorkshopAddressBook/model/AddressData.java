package com.lande.WorkshopAddressBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lande.WorkshopAddressBook.dto.AddressDTO;

import lombok.Data;

@Entity
@Table(name = "address_details")
public @Data class AddressData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int id;
	
	public String address;
	public String city;
	public String state;
	public Long zip;
	public AddressData( AddressDTO dto) {
		super();
		
		this.address = dto.address;
		this.city = dto.city;
		this.state = dto.state;
		this.zip = dto.zip;
		
	}
	public AddressData() {}
	
	
	
	
	

}
