package lk.ijse.cropService.controller;
import lk.ijse.cropService.dto.CropRequest;
import lk.ijse.cropService.dto.CropStatusUpdateRequest;
import lk.ijse.cropService.entity.Crop;
import lk.ijse.cropService.entity.CropStatus;
import lk.ijse.cropService.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public ResponseEntity<Crop> registerCrop(@RequestBody CropRequest request) {
        return ResponseEntity.ok(cropService.addCropBatch(request));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Crop> updateStatus(@PathVariable String id, @RequestBody CropStatusUpdateRequest request) {

        return ResponseEntity.ok(cropService.updateCropStatus(id, CropStatus.valueOf(request.getStatus().toUpperCase())));
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }
}