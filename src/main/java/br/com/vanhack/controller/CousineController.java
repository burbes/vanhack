package br.com.vanhack.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.controller.constant.ControllerConstants;
import br.com.vanhack.domain.Cousine;
import br.com.vanhack.domain.Store;
import br.com.vanhack.service.CousineService;

@RestController
@RequestMapping(value = ControllerConstants.COUSINE)
public class CousineController {

	@Autowired
	private CousineService service;

	@Transactional(readOnly = true)
	@RequestMapping(method = GET)
	public List<Cousine> findAll() {
		return service.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/search/{searchText}")
	public Cousine find(@PathVariable(value = "searchText") String search) {
		return service.find(search);
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/{cousineId}/stores")
	public List<Store> findAllProducts(@PathVariable(value = "cousineId") Integer cousineID) {
		return service.findAllStores(cousineID);
	}

}
