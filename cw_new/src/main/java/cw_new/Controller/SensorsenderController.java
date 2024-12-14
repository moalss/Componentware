package cw_new.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cw_new.Services.SensorsenderService;

@RestController
@RequestMapping()
public class SensorsenderController {
	
	private final SensorsenderService sensorsenderService;

	public SensorsenderController( SensorsenderService sensorsenderService)
	{
		this.sensorsenderService=sensorsenderService;
		
	}

		
		
		
	 @GetMapping("/getLatestWaterLevel")
	    public String getLatestWaterLevel() {
	        Float wasserstand = sensorsenderService.getWasserstand();
	        String info = sensorsenderService.getInfo();
	        if (wasserstand != null) {
	            return "Letzter Wasserstand: " + wasserstand + " cm\n" + "Info: " + info;
	        } else {
	            return "Noch keine Daten empfangen.";
	        }
	    }
		 
	
	}


