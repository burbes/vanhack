package br.com.vanhack.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.vanhack.controller.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = OrderItem.ENTITY_NAME, schema = OrderItem.SCHEMA_NAME)
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 9085819006016873129L;

	public static final String ENTITY_NAME = "ORDER_ITEM";
	public static final String SCHEMA_NAME = "public";

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
	private Order order;

	@OneToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product product;

	@Column(name = "PRICE", columnDefinition = "DOUBLE")
	private BigDecimal price;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "TOTAL", columnDefinition = "DOUBLE")
	private BigDecimal total;

	public OrderItem(Product product, OrderDTO orderDTO, Integer qtde, BigDecimal total) {
		this.product = product;
		this.price = product.getPrice();
		this.quantity = qtde;
		this.total = total;
	}

}
