package cw_new.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cw_new.Repositorys.OrderRepositorys;
import cw_new.Services.OrderService;
import cw_new.entitys.Order;

import java.util.List;



@RestController
@RequestMapping()
public class OrderController {
	@Autowired
    private OrderService orderService;
	@Autowired
    private OrderRepositorys orderRepository;
	
	
	
	 @GetMapping("/test")
	    public String testEndpoint() {
	        return "This is a test!";
	    }
	 
	@GetMapping("/getOrders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrder();
	}
	
	
	 @PostMapping("/setRecieved")
	    public void setRecieved() {
	        orderService.updateOrderStatus((long)1, "RECIEVED");
	    }


	    @PostMapping("/processed")
	    public void setOrderProcessed() {

	        orderService.updateOrderStatus((long) 1,"PROCESSED");
	    
	    }


	    @PostMapping("/setDone")
	    public void setOrderDone() {
	        orderService.updateOrderStatus((long)1, "TOKEN");
	    }
}
