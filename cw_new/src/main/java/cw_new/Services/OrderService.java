package cw_new.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import  cw_new.Repositorys.OrderRepositorys;
import cw_new.entitys.Order;

@Service
public class OrderService {
	
	@Autowired
    private OrderRepositorys orderRepositorrys;
	
	 public List<Order> getAllOrder() {
	        return orderRepositorrys.findAll();
	    }
	  public Order getOrderById(Long id) {
	        return orderRepositorrys.findById(id).orElse(null);
	    }

	    public void save(Order order) {
	    	orderRepositorrys.save(order);
	    }

	    public void markAsReady(Order order) {
	        
	        order.setStatus("READY");
	        orderRepositorrys.save(order);
	    }
	    public void updateOrderStatus(Long orderId, String status) {
	        Order order = orderRepositorrys.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + orderId));
	        order.setStatus(status);
	        orderRepositorrys.save(order);
	    }
	    public Optional<Order> findOrderById(Long orderId) {
			 return orderRepositorrys.findById(orderId);
		}
	
}
