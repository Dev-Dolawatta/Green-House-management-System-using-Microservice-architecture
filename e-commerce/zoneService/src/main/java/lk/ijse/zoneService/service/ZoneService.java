package lk.ijse.zoneService.service;

import lk.ijse.zoneService.client.IOTClient;
import lk.ijse.zoneService.dto.ZoneRequest;
import lk.ijse.zoneService.entity.Zone;
import lk.ijse.zoneService.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private IOTClient iotClient;

    public Zone createZone(ZoneRequest request) {

        Zone zone = new Zone();
        zone.setName(request.getName());
        zone.setMinTemp(request.getMinTemp());
        zone.setMaxTemp(request.getMaxTemp());
        zone = zoneRepository.save(zone);

        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "agasti");
        credentials.put("password", "1234");

        Map<String, String> authResponse = iotClient.login(credentials);
        String token = "Bearer " + authResponse.get("accessToken");

        Map<String, Object> deviceRequest = new HashMap<>();
        deviceRequest.put("zoneId", zone.getId());

        Map<String, Object> response = iotClient.registerDevice(token, deviceRequest);

        System.out.println(" IoT Server Response: " + response);

        if (response != null && response.containsKey("deviceId")) {
            zone.setDeviceId(response.get("deviceId").toString());
            zone = zoneRepository.save(zone);
        }

        return zone;}
}
