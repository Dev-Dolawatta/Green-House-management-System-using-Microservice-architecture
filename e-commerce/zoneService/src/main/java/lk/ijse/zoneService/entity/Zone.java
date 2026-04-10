package lk.ijse.zoneService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Zone {
        @Id
        private String id;

        private String name;

        private double minTemp;

        private double maxTemp;

        private String deviceId;

}
