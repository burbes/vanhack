package br.com.vanhack.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vanhack.domain.Order;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 6137002166604912238L;

	private Integer id;
	private LocalDate dateCreation;
	private Integer customerId;
	private String deliveryAddress;
	private String contact;
	private List<OrderItemDTO> orderItems;
	private BigDecimal total;
	private String status;
	private LocalDate lastUpdate;

	public OrderDTO(Order order) {
		this.id = order.getId();
		dateCreation = order.getDateCreation();
		customerId = order.getCustomer().getId();
		deliveryAddress = order.getDeliveryAddress();
		contact = order.getContact();
		orderItems = order.getOrderItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
		total = order.getTotal();
		status = order.getStatus();
		lastUpdate = order.getLastUpdate();

	}

}
