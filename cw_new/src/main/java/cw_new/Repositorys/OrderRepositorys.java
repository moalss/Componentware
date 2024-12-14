package cw_new.Repositorys;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import  cw_new.entitys.Order;

@Repository
public interface OrderRepositorys extends JpaRepository<Order, Long> {
	
}
