package br.com.vanhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vanhack.controller.dto.UserLoginDTO;
import br.com.vanhack.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(" SELECT c FROM Customer c WHERE c.email = ?1 AND c.password = ?2  ")
	UserLoginDTO findUser(String email, String password);

}
