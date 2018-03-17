package br.com.vanhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vanhack.domain.Cousine;

@Repository
public interface CousineRepository extends JpaRepository<Cousine, Integer> {

	@Query(" SELECT c FROM Cousine c WHERE c.name LIKE ?1 ")
	Cousine findWithSearch(final String search);

}
