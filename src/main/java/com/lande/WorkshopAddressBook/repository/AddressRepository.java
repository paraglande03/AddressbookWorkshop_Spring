package com.lande.WorkshopAddressBook.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lande.WorkshopAddressBook.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,UUID>{
	 			
	 			@Query(value = " select * FROM address_details ORDER BY address ASC",nativeQuery = true)
	 			List<Address> SortingAddressAsc();

	 			
	 			
}
