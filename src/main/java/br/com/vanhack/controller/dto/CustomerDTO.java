package br.com.vanhack.controller.dto;

import java.time.LocalDate;

import br.com.vanhack.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerDTO {

	private Integer		id;
	private String		email;
	private String		name;
	private String		address;
	private LocalDate	dateCreation;
	private String		password;

	public CustomerDTO(Customer customer) {
		id = customer.getId();
		email = customer.getEmail();
		name = customer.getName();
		address = customer.getAddress();
		dateCreation = customer.getDateCreation();
		password = customer.getPassword();
	}

}
