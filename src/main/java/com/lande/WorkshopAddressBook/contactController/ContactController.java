package com.lande.WorkshopAddressBook.contactController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lande.WorkshopAddressBook.dto.AddressDTO;
import com.lande.WorkshopAddressBook.dto.ContactDTO;
import com.lande.WorkshopAddressBook.dto.ResponseDTO;
import com.lande.WorkshopAddressBook.model.AddressData;
import com.lande.WorkshopAddressBook.model.ContactData;
import com.lande.WorkshopAddressBook.service.ContactServiceInterface;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private	ContactServiceInterface Service;
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllContacts() {
		List<ContactData> contactData = Service.getAllContacts();
		ResponseDTO responseDTO = new ResponseDTO("success", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("Id") int Id) {
		ContactData contactData = Service.getContactById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createContact(@RequestBody ContactDTO dto) {
		ContactData contactData = Service.createContact(dto);
		ResponseDTO responseDTO = new ResponseDTO("success", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable ("Id") Integer Id, @RequestBody  ContactDTO dto) {
		ContactData contactData = Service.updatedataById(Id, dto);
		ResponseDTO responseDTO = new ResponseDTO("success", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("Id") int Id) {
		Service.deleteDataById(Id);
		ResponseDTO responseDTO = new ResponseDTO("success :-", Id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	
}
