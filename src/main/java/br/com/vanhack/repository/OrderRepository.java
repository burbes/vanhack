package br.com.vanhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vanhack.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
