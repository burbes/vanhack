package br.com.vanhack.controller.dto;

import java.math.BigDecimal;

import br.com.vanhack.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class OrderItemDTO {

	private Integer id;
	private Integer productId;
	private BigDecimal price;
	private Integer quantity;
	private BigDecimal total;

	public OrderItemDTO(OrderItem entity) {
		this.id = entity.getId();
		this.productId = entity.getProduct().getId();
		this.price = entity.getPrice();
		this.quantity = entity.getQuantity();
		this.total = entity.getTotal();
	}
}
