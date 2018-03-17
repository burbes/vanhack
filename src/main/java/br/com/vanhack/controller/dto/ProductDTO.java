package br.com.vanhack.controller.dto;

import java.math.BigDecimal;

import br.com.vanhack.domain.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

	private Integer id;
	private Integer storeId;
	private String name;
	private String description;
	private BigDecimal price;

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		// this.storeId = entity.getStoreId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();

	}
}
