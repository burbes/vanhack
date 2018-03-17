package br.com.vanhack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.domain.Product;
import br.com.vanhack.repository.ProductRepository;
import br.org.sesc.commons.query.SQLUtils;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product find(String search) {
		return repository.findBy(SQLUtils.like(search));
	}

	public Product findOne(Integer id) {
		return repository.findOne(id);
	}

}
