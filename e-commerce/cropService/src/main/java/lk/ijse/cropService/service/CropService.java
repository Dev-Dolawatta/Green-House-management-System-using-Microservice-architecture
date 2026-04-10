package lk.ijse.cropService.service;
import lk.ijse.cropService.dto.CropRequest;
import lk.ijse.cropService.entity.Crop;
import lk.ijse.cropService.entity.CropStatus;
import lk.ijse.cropService.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public Crop addCropBatch(CropRequest request) {
        Crop crop = new Crop();

        crop.setStatus(CropStatus.SEEDLING);
        crop.setCropName(request.getCropName());

        crop.setBatchNo(request.getBatchNo());
        return cropRepository.save(crop);
    }

    public Crop updateCropStatus(String id, CropStatus newStatus) {
        Optional<Crop> optionalCrop = cropRepository.findById(id);
        if (optionalCrop.isPresent()) {
            Crop crop = optionalCrop.get();
            crop.setStatus(newStatus);
            return cropRepository.save(crop);
        }
        throw new RuntimeException("Crop not found with id: " + id);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }
}