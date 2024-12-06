package CW.Componentware.Srvices;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CW.Componentware.Repositorys.NachrichtRepository;
import CW.Componentware.entitys.Sensorsender;

@Service
public class NachrichtService {
	
private final  NachrichtRepository nachrichtRepository;



public NachrichtService(NachrichtRepository nachrichtRepository)
{
	this.nachrichtRepository=nachrichtRepository;
}



	
public void verarbeiten(String payload) {
	
	try {
		
		Float wasserstand = Float.parseFloat(payload);
		
		
		Sensorsender sensorsender= new Sensorsender(payload, wasserstand,LocalDateTime.now(),"Ultra");
		
		if(wasserstand<10) {
			
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
