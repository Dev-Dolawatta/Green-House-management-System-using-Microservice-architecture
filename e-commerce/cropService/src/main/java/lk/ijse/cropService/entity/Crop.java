package lk.ijse.cropService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Crop {
    @Id
    private String id;

    private String name;

    private String status;

}
