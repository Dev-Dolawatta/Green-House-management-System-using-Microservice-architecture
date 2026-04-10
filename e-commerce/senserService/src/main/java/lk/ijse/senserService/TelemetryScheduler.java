package lk.ijse.senserService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TelemetryScheduler {

    @Scheduled(fixedRate = 10000)
    public void fetchTelemetry(){

        System.out.println("Fetching telemetry from IoT API");

    }

}