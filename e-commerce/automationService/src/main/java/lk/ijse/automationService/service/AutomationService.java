package lk.ijse.automationService.service;
import lk.ijse.automationService.client.ZoneClient;
import lk.ijse.automationService.dto.SensorData;
import lk.ijse.automationService.dto.ZoneDTO;
import lk.ijse.automationService.entity.ActionLog;
import lk.ijse.automationService.repository.ActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomationService {

    @Autowired
    private ZoneClient zoneClient;

    @Autowired
    private ActionLogRepository actionLogRepository;

    public void processSensorData(SensorData sensorData) {
        ZoneDTO zone = null;

        try {
            zone = zoneClient.getZoneById(sensorData.getZoneId());
        } catch (feign.FeignException.NotFound e) {
            System.out.println("Zone not found in DB for ID: " + sensorData.getZoneId() + ". Ignoring data.");
            return;
        }

        if (zone != null) {
            Double currentTemp = sensorData.getTemperature();

            if (currentTemp == null) {
                System.out.println(" Waiting for temperature data... (currentTemp is null)");
                return;
            }

            String action = null;

            if (currentTemp > zone.getMaxTemp()) {
                action = "TURN_FAN_ON";
            } else if (currentTemp < zone.getMinTemp()) {
                action = "TURN_HEATER_ON";
            }

            if (action != null) {
                ActionLog log = new ActionLog();
                log.setZoneId(sensorData.getZoneId());
                log.setDeviceId(sensorData.getDeviceId());
                log.setRecordedTemperature(currentTemp);
                log.setAction(action);

                actionLogRepository.save(log);
                System.out.println(" Action Logged: " + action + " for Zone: " + sensorData.getZoneId() + " (Temp: " + currentTemp + ")");
            }
        }
    }
}