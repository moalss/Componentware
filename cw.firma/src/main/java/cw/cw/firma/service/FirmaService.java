package cw.cw.firma.service;

import cw.cw.firma.entity.SensorData;
import cw.cw.firma.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaService {

    private final SensorDataRepository sensorDataRepository;

    public FirmaService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }
    
    

    public SensorData saveSensorData(String data) {
        SensorData sensorData = new SensorData();
        sensorData.setData(data);
        sensorData.setTimestamp(java.time.LocalDateTime.now());
        return sensorDataRepository.save(sensorData);
    }
}
