package lk.ijse.automationService.client;
import lk.ijse.automationService.dto.ZoneDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zone-service")
public interface ZoneClient {

    @GetMapping("/api/zones/{id}")
    ZoneDTO getZoneById(@PathVariable("id") String id);
}