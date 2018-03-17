package br.com.vanhack.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.controller.constant.ControllerConstants;
import br.com.vanhack.controller.dto.CustomerDTO;
import br.com.vanhack.controller.dto.OrderDTO;
import br.com.vanhack.domain.Order;
import br.com.vanhack.service.OrderService;
import javassist.NotFoundException;

@RestController
@RequestMapping(value = ControllerConstants.ORDER)
public class OrderController {

	@Autowired
	OrderService orderService;

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/{orderId}")
	public Response retrieve(@PathVariable(value = "orderId") Integer id) throws NotFoundException {
		Order order = orderService.find(id);

		if (Objects.isNull(order)) {
			throw new NotFoundException("You must give a valid id");
		}

		return Response.ok(order).build();
	}

	@RequestMapping(method = POST)
	public Response insert(@RequestBody OrderDTO orderDTO) throws NotFoundException {

		Order order = orderService.insert(orderDTO);

		if (Objects.isNull(order)) {
			throw new BadRequestException("Something is not right in your insertion");
		}
		return Response.ok(order).build();
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET)
	public List<CustomerDTO> findAllCustomers() {
		return orderService.findAll();
	}

}
