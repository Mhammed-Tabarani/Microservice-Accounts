package org.sid.Account_service.restClient;

import org.sid.Account_service.dto.DriverRequestDTO;
import org.sid.Account_service.dto.DriverResponseDTO;
import org.sid.Account_service.dto.PassengerRequestDTO;
import org.sid.Account_service.dto.PassengerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class AuthenticationRestClient {
    @Autowired
    RestTemplate restTemplate;

    public void passengerRegister(PassengerRequestDTO passengerRequestDTO) {
         restTemplate.postForObject("https://authentication-microservice-production.up.railway.app/auth/passenger-register", passengerRequestDTO,PassengerRequestDTO.class);

    }
    public void driverRegister(DriverRequestDTO driverRequestDTO) {
        restTemplate.postForObject("https://authentication-microservice-production.up.railway.app/auth/driver-register", driverRequestDTO,DriverRequestDTO.class);

    }
}
