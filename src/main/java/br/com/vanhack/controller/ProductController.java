package br.com.vanhack.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.controller.constant.ControllerConstants;
import br.com.vanhack.domain.Product;
import br.com.vanhack.service.ProductService;

@RestController
@RequestMapping(value = ControllerConstants.PRODUCT)
public class ProductController {

	@Autowired
	private ProductService service;

	@Transactional(readOnly = true)
	@RequestMapping(method = GET)
	public List<Product> findAll() {
		return service.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/search/{seachText}")
	public Product find(@PathVariable String search) {
		return service.find(search);
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/{productId}")
	public Product find(@PathVariable Integer productId) {
		return service.findOne(productId);
	}

}
