package lk.ijse.senserService.service;

import lk.ijse.senserService.client.AutomationClient;
import lk.ijse.senserService.client.IotClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SensorSchedulerService {

    @Autowired
    private IotClient iotClient;

    @Autowired
    private AutomationClient automationClient;

    private Map<String, Object> latestReading = new HashMap<>();

    @Scheduled(fixedRate = 10000)
    public void fetchAndPushSensorData() {

        try {
            Map<String, String> credentials = new HashMap<>();
            credentials.put("username", "agasti");
            credentials.put("password", "1234");

            Map<String, Object> loginResponse = iotClient.login(credentials);
            String token = (String) loginResponse.get("accessToken");
            String bearerToken = "Bearer " + token;

            List<Map<String, Object>> devices = iotClient.getAllDevices(bearerToken);

            for (Map<String, Object> device : devices) {
                String deviceId = (String) device.get("deviceId");

                Map<String, Object> telemetry = iotClient.getTelemetry(bearerToken, deviceId);

                this.latestReading = telemetry;

                System.out.println("Fetched Telemetry: " + telemetry);

                automationClient.sendSensorData(telemetry);


            }

        } catch (Exception e) {
            System.out.println("Error fetching or pushing sensor data: " + e.getMessage());
        }
    }

    public Map<String, Object> getLatestReading() {
        return latestReading;
    }
}
