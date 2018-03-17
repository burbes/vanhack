package br.com.vanhack.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = Order.ENTITY_NAME, schema = Order.SCHEMA_NAME)
public class Order implements Serializable {

	private static final long serialVersionUID = 4485002535879443618L;

	public static final String ENTITY_NAME = "PEDIDO";
	public static final String SCHEMA_NAME = "public";

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Column(name = "DATE", columnDefinition = "DATE")
	private LocalDate dateCreation;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	private Customer customer;

	@Column(name = "DELIVERY_ADDRESS", nullable = false)
	private String deliveryAddress;

	@Column(name = "CONTACT")
	private String contact;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	@Column(name = "total", nullable = false, columnDefinition = "DOUBLE")
	private BigDecimal total;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "LAST_UPDATE", columnDefinition = "DATE")
	private LocalDate lastUpdate;

}
