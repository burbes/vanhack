package br.com.vanhack.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.controller.constant.ControllerConstants;
import br.com.vanhack.domain.Product;
import br.com.vanhack.domain.Store;
import br.com.vanhack.service.StoreService;

@RestController
@RequestMapping(value = ControllerConstants.STORE)
public class StoreController {

	@Autowired
	private StoreService service;

	@Transactional(readOnly = true)
	@RequestMapping(method = RequestMethod.GET)
	public List<Store> findAll() {
		return service.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/search/{seachText}")
	public Store find(@PathVariable String search) {
		return service.find(search);
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/{storeId}")
	public Store find(@PathVariable Integer storeId) {
		return service.findOne(storeId);
	}

	@Transactional(readOnly = true)
	@RequestMapping(method = GET, value = "/{storeId}/products")
	public List<Product> findAllProducts(@PathVariable Integer storeID) {
		return service.findAllProducts(storeID);
	}
	
//	@RequestMapping(method = GET, value = "{id}")
//	public Store find(@PathVariable Long id) {
//		return vacinaService.findOne(id);
//	}


	// @RequestMapping(method = POST)
	// public Store insert(@RequestBody StoreForm vacinaForm) {
	// return vacinaService.insert(vacinaForm);
	// }
	//
	// @RequestMapping(method = PUT, value = "{id}")
	// public Store update(@PathVariable Long id, @RequestBody StoreForm
	// vacinaForm) {
	// return vacinaService.update(id, vacinaForm);
	// }

//	@RequestMapping(method = DELETE, value = "{id}")
//	public HttpStatus delete(@PathVariable Long id) {
//		return vacinaService.delete(id);
//	}
}
