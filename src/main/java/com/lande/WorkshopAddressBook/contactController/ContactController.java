package com.lande.WorkshopAddressBook.contactController;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.dto.ResponseDTO;
import com.lande.WorkshopAddressBook.model.Contact;
import com.lande.WorkshopAddressBook.service.ContactServiceInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private	ContactServiceInterface service;
	
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getAllContacts() {
		List<Contact> contact = service.getAllContacts();
		ResponseDTO responseDTO = new ResponseDTO("All Contacts!", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("Id") UUID Id) {
		Contact contact = service.getContactById(Id);
		ResponseDTO responseDTO = new ResponseDTO("Contact Of Id:-"+Id, contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createContact(@RequestBody @Valid ContactDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.info("Please enter valid information");
			ResponseDTO responseDTO = new ResponseDTO("Error in :"+bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		
		Contact contact = service.createContact(dto);
		ResponseDTO responseDTO = new ResponseDTO("Created New Contact!", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable ("Id") UUID Id, @RequestBody @Valid ContactDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.info("Please enter valid information");
			ResponseDTO responseDTO = new ResponseDTO("Error in :"+bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		
		Contact contact = service.updatedataById(Id, dto);
		ResponseDTO responseDTO = new ResponseDTO("Updated contact of Id:-"+Id, contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("Id") UUID Id) {
		service.deleteDataById(Id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted COntactOf ID:-" +Id, Id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<ResponseDTO> sortContactByValue(){
		
		List<Contact> contact = service.sortContact();
		ResponseDTO responseDTO = new ResponseDTO("Sorted! Contacts..", contact);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK); 
	}
	
	
	
	
}

	
	

