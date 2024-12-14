package cw_new.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cw_new.Repositorys.NachrichtRepository;
import  cw_new.Repositorys.OrderRepositorys;
import  cw_new.entitys.Order;
import  cw_new.entitys.Sensorsender;

@Service
public class NachrichtService {
	

private final  OrderService orderService;


public NachrichtService( OrderService orderService)
{
	
	this.orderService=orderService;
}



	
public void verarbeiten(String payload) {
	
	try {
		
		Float wasserstand = Float.parseFloat(payload);
		
		
		Sensorsender sensorsender= new Sensorsender(payload, wasserstand,LocalDateTime.now(),"Ultra");
		
		if(wasserstand<10) {
			
			Order order= new Order(LocalDateTime.now(), 100.0,"RECIEVED");
			//order.setStatus("RECIEVED");
			orderService.save(order);
			
			
			System.out.println("WARNUNG: Wasserstand ist kritisch niedrig: " + wasserstand + " cm");
		}
            // Hier könntest du einen Auftrag erstellen oder eine Benachrichtigung auslösen
            //erstelleAuftrag(sensorsender);
		
       
		// in db save
		
	} catch (NumberFormatException e) {
        System.err.println("Ungültiges Payload-Format: " + payload);
    }
		
	
	}

}
