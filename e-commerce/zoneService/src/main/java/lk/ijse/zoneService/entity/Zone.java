package lk.ijse.zoneService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "zones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zone {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;

        private String name;

        private Double minTemp;
        private Double maxTemp;

        private String deviceId;
}