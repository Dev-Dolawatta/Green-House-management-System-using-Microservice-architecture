package lk.ijse.automationService.controller;
import lk.ijse.automationService.dto.SensorData;
import lk.ijse.automationService.entity.ActionLog;
import lk.ijse.automationService.repository.ActionLogRepository;
import lk.ijse.automationService.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    @Autowired
    private AutomationService automationService;

    @Autowired
    private ActionLogRepository actionLogRepository;

    @PostMapping("/process")
    public ResponseEntity<String> receiveSensorData(@RequestBody SensorData sensorData) {
        automationService.processSensorData(sensorData);
        return ResponseEntity.ok("Data processed successfully");
    }

    @GetMapping("/logs")
    public ResponseEntity<List<ActionLog>> getAutomationLogs() {
        return ResponseEntity.ok(actionLogRepository.findAll());
    }

}
