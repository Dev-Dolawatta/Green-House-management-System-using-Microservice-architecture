package lk.ijse.senserService.controller;

import lk.ijse.senserService.service.SensorSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorSchedulerService sensorSchedulerService;

    @GetMapping("/latest")
    public Map<String, Object> getLatestReading() {
        return sensorSchedulerService.getLatestReading();
    }

}
