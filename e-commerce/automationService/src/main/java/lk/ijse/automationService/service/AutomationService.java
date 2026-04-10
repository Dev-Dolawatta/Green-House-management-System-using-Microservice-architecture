package lk.ijse.automationService.service;

import org.springframework.stereotype.Service;

@Service
public class AutomationService {
    public String applyRule(double temp,double min,double max){

        if(temp > max){
            return "TURN_FAN_ON";
        }

        if(temp < min){
            return "TURN_HEATER_ON";
        }

        return "NO_ACTION";
    }

}
