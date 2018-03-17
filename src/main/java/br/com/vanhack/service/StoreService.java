package br.com.vanhack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanhack.domain.Product;
import br.com.vanhack.domain.Store;
import br.com.vanhack.repository.ProductRepository;
import br.com.vanhack.repository.StoreRepository;
import br.org.sesc.commons.query.SQLUtils;

@Service
public class StoreService {

	@Autowired
	private StoreRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<Store> findAll() {
		return repository.findAll();
	}

	public Store find(String search) {
		return repository.findWith(SQLUtils.like(search));
	}

	public Store findOne(Integer id) {
		return repository.findOne(id);
	}

	public List<Product> findAllProducts(Integer storeID) {
		return productRepository.findAllBy(storeID);
	}

}
