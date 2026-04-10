package lk.ijse.automationService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ActionLog {
    @Id
    private String id;

    private String zoneId;

    private double temperature;

    private String action;
}
