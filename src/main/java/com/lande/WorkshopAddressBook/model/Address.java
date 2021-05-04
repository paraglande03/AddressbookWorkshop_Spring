package com.lande.WorkshopAddressBook.model;

import java.lang.instrument.ClassFileTransformer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ContactDTO;

import javassist.CtBehavior;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@Table(name = "address_details")
public @Data class Address {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2" , strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID id;
	

	
	
	@CreationTimestamp
	private LocalDateTime created_on ;
	public String address;
	public String city;
	public String state;
	public String zip;
	
	
	


	
	
 
	
	@UpdateTimestamp
	private LocalDateTime updated_on;
	

	public Address( AddressDTO dto) {
		super();
		
		this.address = dto.address;
		this.city = dto.city;
		this.state = dto.state;
		this.zip = dto.zip;
		
	}
	public Address() {}
//	@Override
//	public String toString() {
//		return "Address [id=" + id + ", created_on=" + created_on + ", address=" + address + ", city=" + city
//				+ ", state=" + state + ", zip=" + zip + ", Contacts=" + Contacts + ", updated_on=" + updated_on + "]";
//	}

	
	
	
	

}
