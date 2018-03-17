package br.com.vanhack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vanhack.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(" SELECT p FROM Product p WHERE p.name LIKE ?1 OR p.description LIKE ?1 OR p.price LIKE ?1 ")
	Product findBy(String search);

	@Query(" SELECT p FROM Product p WHERE p.store.id = ?1 ")
	List<Product> findAllBy(Integer storeID);

	List<Product> findAllByIdIn(List<Integer> productsID);
}
