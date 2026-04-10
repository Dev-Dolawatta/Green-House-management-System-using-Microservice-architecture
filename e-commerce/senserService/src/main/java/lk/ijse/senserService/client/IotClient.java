package lk.ijse.senserService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "iot-client", url = "http://localhost:8088/api")
public  interface IotClient {

    @PostMapping("/auth/login")
    Map<String, Object> login(@RequestBody Map<String, String> credentials);

    @GetMapping("/devices")
    List<Map<String, Object>> getAllDevices(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/devices/telemetry/{device-id}")
    Map<String, Object> getTelemetry(@RequestHeader("Authorization") String bearerToken, @PathVariable("device-id") String deviceId);
}