package com.lande.WorkshopAddressBook.model;


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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lande.WorkshopAddressBook.dto.ContactDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "contact_details")
public @Data class Contact {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2" , strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID id;
	
	@DateTimeFormat
	@CreationTimestamp
	private LocalDateTime created_on ;
	public String first_name;
	public String last_name;
	public String email;
	public String phoneNumber;
	@UpdateTimestamp
	private LocalDateTime updated_on;


    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	
	private Address address;



	public Contact( ContactDTO dto) {
		super();
	
				
		
		this.first_name = dto.first_name;
		this.last_name = dto.last_name;
		this.email = dto.email;
		this.phoneNumber = dto.phoneNumber;
		
		
	}

	public Contact() {
	
}


}