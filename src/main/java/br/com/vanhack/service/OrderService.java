package br.com.vanhack.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.controller.dto.CustomerDTO;
import br.com.vanhack.controller.dto.OrderDTO;
import br.com.vanhack.controller.dto.OrderItemDTO;
import br.com.vanhack.domain.Customer;
import br.com.vanhack.domain.Order;
import br.com.vanhack.domain.OrderItem;
import br.com.vanhack.domain.Product;
import br.com.vanhack.repository.CustomerRepository;
import br.com.vanhack.repository.OrderRepository;
import br.com.vanhack.repository.ProductRepository;
import javassist.NotFoundException;

@Service
public class OrderService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository repository;

	public Order insert(OrderDTO orderDTO) throws NotFoundException {

		Customer customer = customerRepository.findOne(orderDTO.getCustomerId());

		List<Product> products = getProducts(orderDTO);

		BigDecimal total = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

		List<OrderItem> itens = getItens(orderDTO, products, total);

		Order order = Order.builder()
				.contact(orderDTO.getContact())
				.customer(customer)
				.dateCreation(LocalDate.now())
				.deliveryAddress(orderDTO.getDeliveryAddress())
				.lastUpdate(orderDTO.getLastUpdate())
				.orderItems(itens)
				.status("ORDER")
				.total(total)
				.build();

		repository.save(order);

		return order;
	}

	private List<OrderItem> getItens(OrderDTO orderDTO, List<Product> products, BigDecimal total) {
		List<OrderItem> itens = new ArrayList<>();
		for (Product product : products) {
			OrderItem orderItem = new OrderItem(product, orderDTO, products.size(), total);
			itens.add(orderItem);
		}
		return itens;
	}

	private List<Product> getProducts(OrderDTO orderDTO) throws NotFoundException {

		List<Integer> productsID = orderDTO.getOrderItems().stream().map(OrderItemDTO::getProductId).collect(Collectors.toList());

		if (Objects.isNull(productsID) || productsID.isEmpty()) {
			throw new NotFoundException("Product(s) not found");
		}

		List<Product> products = productRepository.findAllByIdIn(productsID);

		return products;
	}

	public Order find(Integer id) {
		return repository.findOne(id);
	}

	public List<CustomerDTO> findAll() {
		return customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

}
