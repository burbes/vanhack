package br.com.vanhack.controller;

import static br.com.vanhack.controller.constant.ControllerConstants.CUSTOMER;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Objects;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.controller.dto.UserDTO;
import br.com.vanhack.controller.dto.UserLoginDTO;
import br.com.vanhack.domain.Customer;
import br.com.vanhack.service.CustomerService;
import javassist.NotFoundException;

@RestController
@RequestMapping(value = CUSTOMER)
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = POST, value = "auth")
	public HttpStatus auth(UserLoginDTO user) throws NotFoundException {
		UserLoginDTO auth = customerService.auth(user);
		return Objects.nonNull(auth) ? HttpStatus.OK : HttpStatus.BAD_GATEWAY;
	}

	@RequestMapping(method = POST)
	public Response insert(@RequestBody UserDTO user) {

		Customer customer = new Customer(user);

		customerService.insert(customer);

		return Objects.nonNull(customer) ? Response.ok(customer).build() : Response.status(Response.Status.BAD_GATEWAY).build();
	}

}
