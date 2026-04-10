package lk.ijse.zoneService.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "iot-client", url = "http://localhost:8088/api")
public interface IOTClient {

    @PostMapping("/auth/login")
    Map<String, String> login(@RequestBody Map<String, String> credentials);

    @PostMapping("/devices")
    Map<String, Object> registerDevice(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody);
}