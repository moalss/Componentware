package cw_new.Mqtt;



import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cw_new.Services.NachrichtService;
import jakarta.annotation.PostConstruct;

@Service
public class MqttSubscriber {

	
	private final NachrichtService nachrichtService;
	
	@Value("${mqtt.broker}")
	private String brokerUrl;

	@Value("${mqtt.topic}")
	private String topic;
	
	
	
    public MqttSubscriber(NachrichtService nachrichtService) {
	
		this.nachrichtService = nachrichtService;
	}



	@PostConstruct
    public void connectToMqttBroker() {
        try {
            MqttClient client = new MqttClient(brokerUrl, MqttClient.generateClientId());
            client.connect();

            client.subscribe(topic, (topic, message) -> {
                String payload = new String(message.getPayload());
                System.out.println("Empfangene Nachricht: " + payload);//TODO Löschen

               nachrichtService.verarbeiten(payload);
                	
                
            });
            
            System.out.println("Mit MQTT-Broker verbunden und abonniert: " + topic);//TODO Löschen
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }



	
	
	
	
}
