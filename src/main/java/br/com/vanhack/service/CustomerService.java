package br.com.vanhack.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.controller.dto.UserLoginDTO;
import br.com.vanhack.domain.Customer;
import br.com.vanhack.repository.CustomerRepository;
import javassist.NotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public UserLoginDTO auth(UserLoginDTO user) throws NotFoundException {
		UserLoginDTO userFound = repository.findUser(user.getEmail(), user.getPassword());

		if (Objects.isNull(userFound)) {
			throw new NotFoundException("User not found");
		}

		return user;
	}

	public void insert(Customer customer) {
		repository.save(customer);
	}

}
