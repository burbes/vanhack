package br.com.vanhack.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = Product.ENTITY_NAME, schema = Product.SCHEMA_NAME)
public class Product implements Serializable {

	private static final long serialVersionUID = 5447700345782667759L;

	public static final String ENTITY_NAME = "PRODUCT";
	public static final String SCHEMA_NAME = "public";

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "STORE_ID")
	private Store store;

	@NotNull
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

	@NotNull
	@Column(name = "DESCRIPTION", nullable = false, length = 300)
	private String description;

	@Column(name = "PRICE", columnDefinition = "DOUBLE")
	private BigDecimal price;

	@OneToOne(fetch = LAZY, mappedBy = "product", orphanRemoval = true)
	private OrderItem orderItem;

}
