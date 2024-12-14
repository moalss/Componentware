package cw_new.entitys;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
@Column(name = "orderDate")
    private LocalDateTime orderDate;

//@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//private List< Order> products = new ArrayList<>();

@Column(name = "totalPrice")
private Double totalPrice;


//@ManyToOne
//@JoinColumn(name = "sensor_id", referencedColumnName = "id")
//private SensorSender sensorSender;
 

    @Column(name = "status")
    private String status;

//    @Column(name = "rating")
//    private Integer rating; 
    
    
	public Order(LocalDateTime orderDate,Double totalPrice, String status) {
		super();
		
		this.totalPrice = totalPrice;
		this.orderDate=orderDate;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

//
//	public List<Order> getProducts() {
//		return Order;
//	}


//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


//	public SensorSender getSensorSender() {
//		return sensorSender;
//	}
//
//
//	public void setSensorSender(SensorSendor sensorSender) {
//		this.sensorSender = sensorSender;
//	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Order() {
		super();
		 
	}
//	public Order(Date orderDate, List<Item> items, Double totalPrice, User user, String status) {
//		super();
//		this.orderDate = orderDate;
//		this.items = items;
//		this.totalPrice = totalPrice;
//		this.user = user;
//		this.status = status;
//	}
	
}
