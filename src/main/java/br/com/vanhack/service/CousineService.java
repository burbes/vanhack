package br.com.vanhack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanhack.domain.Cousine;
import br.com.vanhack.domain.Store;
import br.com.vanhack.repository.CousineRepository;
import br.com.vanhack.repository.StoreRepository;
import br.org.sesc.commons.query.SQLUtils;

@Service
public class CousineService {

	@Autowired
	private CousineRepository repository;

	@Autowired
	private StoreRepository storeRepository;

	@Transactional(readOnly = true)
	public List<Cousine> findAll() {
		return repository.findAll();
	}

	public Cousine find(String search) {
		return repository.findWithSearch(SQLUtils.like(search));
	}

	public List<Store> findAllStores(Integer storeID) {
		return storeRepository.findAllCousines(storeID);
	}

}
