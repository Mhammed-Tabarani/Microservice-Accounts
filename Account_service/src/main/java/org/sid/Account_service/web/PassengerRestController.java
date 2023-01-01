package org.sid.Account_service.web;

import lombok.AllArgsConstructor;
import org.sid.Account_service.entities.Driver;
import org.sid.Account_service.entities.Passenger;
import org.sid.Account_service.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class PassengerRestController {
    private PassengerRepository passengerRepository;

    @GetMapping("/passengers")
    public List<Passenger> drivers(){return passengerRepository.findAll();}

    @GetMapping("/passengers/{id}")
    public Passenger driver(@PathVariable String id){
        return passengerRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/passengers")
    public Passenger save(@RequestBody Passenger passenger){
        if(passenger.getId()==null) passenger.setId(UUID.randomUUID().toString());
        return passengerRepository.save(passenger);
    }

    @PutMapping("/drivers/{id}")
    public Passenger update(@PathVariable String id , Passenger passenger){
        Passenger passenger1= passengerRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s bot found",id)));
        return passengerRepository.save(passenger);
    }
    @DeleteMapping("/drivers/{id}")
    public void delete(@PathVariable String id){passengerRepository.deleteById(id);}
    @GetMapping("/Passengers/{email}")
    public Passenger getbyEmail(@PathVariable String email){

        return passengerRepository.findPassengerByEmail(email);
    }

}
