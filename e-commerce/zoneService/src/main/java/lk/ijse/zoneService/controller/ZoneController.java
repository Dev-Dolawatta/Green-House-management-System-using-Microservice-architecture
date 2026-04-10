package lk.ijse.zoneService.controller;
import lk.ijse.zoneService.dto.ZoneRequest;
import lk.ijse.zoneService.entity.Zone;
import lk.ijse.zoneService.repository.ZoneRepository;
import lk.ijse.zoneService.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private ZoneRepository zoneRepository;

    @PostMapping
    public ResponseEntity<Zone> createZone(@RequestBody ZoneRequest request) {
        Zone createdZone = zoneService.createZone(request);
        return ResponseEntity.ok(createdZone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZone(@PathVariable String id) {
        Optional<Zone> zone = zoneRepository.findById(id);
        return zone.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable String id) {
        zoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable String id, @RequestBody ZoneRequest request) {
        if (request.getMinTemp() >= request.getMaxTemp()) {
            throw new IllegalArgumentException("Min temp must be  less than max temp");
        }

        Optional<Zone> existingZone = zoneRepository.findById(id);
        if (existingZone.isPresent()) {
            Zone zone = existingZone.get();
            zone.setMinTemp(request.getMinTemp());
            zone.setMaxTemp(request.getMaxTemp());
            return ResponseEntity.ok(zoneRepository.save(zone));
        }
        return ResponseEntity.notFound().build();
    }
}
