package lk.ijse.zoneService.dto;

import lombok.Data;

@Data
public class ZoneRequest {
    private String name;
    private Double minTemp;
    private Double maxTemp;
}