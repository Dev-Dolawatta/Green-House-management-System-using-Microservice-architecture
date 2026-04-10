package lk.ijse.automationService.dto;

import lombok.Data;

@Data
public class SensorData {
    private String deviceId;
    private String zoneId;
    private Double temperature;
    private Double humidity;
}
