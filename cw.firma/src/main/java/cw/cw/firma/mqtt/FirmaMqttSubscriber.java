package cw.cw.firma.mqtt;

import cw.cw.firma.entity.SensorData;
import cw.cw.firma.repository.SensorDataRepository;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@Service
public class FirmaMqttSubscriber {

    private final SensorDataRepository sensorDataRepository;

    @Value("${mqtt.broker}")
    private String brokerUrl;

    @Value("${mqtt.topic}")
    private String topic;

    public FirmaMqttSubscriber(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @PostConstruct
    
    public void connectToMqttBroker() {
        try {
            MqttClient client = new MqttClient(brokerUrl, MqttClient.generateClientId());
            client.connect();

            client.subscribe(topic, (topic, message) -> {
                String payload = new String(message.getPayload());
                System.out.println("Empfangene Nachricht: " + payload);

                // Speichere die Nachricht in der Datenbank
                SensorData sensorData = new SensorData();
                sensorData.setData(payload);
                sensorData.setTimestamp(LocalDateTime.now());
                Integer num=5;
               
             
                	
                	sensorDataRepository.save(sensorData);
                	
                
            });

            System.out.println("Mit MQTT-Broker verbunden und abonniert: " + topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
