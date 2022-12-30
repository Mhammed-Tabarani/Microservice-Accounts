package org.sid.Account_service.web;

import lombok.AllArgsConstructor;
import org.sid.Account_service.entities.Passenger;
import org.sid.Account_service.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PassengerRestController {
    private PassengerRepository passengerRepository;


    @GetMapping("/Passengers/{email}")
    public Passenger getbyEmail(@PathVariable String email){
        return passengerRepository.findPassengerByEmail(email);
    }

}
