package lk.ijse.cropService.dto;

public class CropRequest {
    private String cropName;
    private String batchNo;

    public CropRequest() {
    }

    public CropRequest(String cropName, String batchNo) {
        this.cropName = cropName;
        this.batchNo = batchNo;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
