package cw.cw.firma.controller;

import cw.cw.firma.entity.SensorData;
import cw.cw.firma.repository.SensorDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class SensorDataController {

    private final SensorDataRepository sensorDataRepository;

    public SensorDataController(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @GetMapping("/api/sensor-data")
    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }
}
