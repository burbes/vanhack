package br.com.vanhack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vanhack.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

	@Query(" SELECT s FROM Store s WHERE s.name LIKE ?1 OR s.address LIKE ?1 ")
	Store findWith(final String search);

	@Query(" SELECT s FROM Store s WHERE s.cousine.id = ?1 ")
	List<Store> findAllCousines(final Integer cousineId);
}
