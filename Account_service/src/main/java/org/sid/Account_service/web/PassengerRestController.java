package org.sid.Account_service.web;

import org.sid.Account_service.dto.PassengerRequestDTO;
import org.sid.Account_service.dto.PassengerResponseDTO;
import org.sid.Account_service.entities.Passenger;
import org.sid.Account_service.repositories.PassengerRepository;
import org.sid.Account_service.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class PassengerRestController {
    @Autowired
    private PassengerRepository passengerRepository;
    private PassengerService passengerService;

    public PassengerRestController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/passengers")
    public List<PassengerResponseDTO> drivers(){return passengerService.getAllPassengers();}

    @GetMapping("/passengers/{id}")
    public PassengerResponseDTO driver(@PathVariable String id){
        return passengerService.getPassengerByPublicId(id);
    }
    @PostMapping("/passengers")
    public PassengerResponseDTO save(@RequestBody PassengerRequestDTO passengerRequestDTO){
        return passengerService.addPassenger(passengerRequestDTO);
    }

    @PutMapping("/passengers/{id}")
    public PassengerResponseDTO update(@PathVariable String id , PassengerRequestDTO passengerRequestDTO){
        return passengerService.updatePassenger(id,passengerRequestDTO);
    }
    @DeleteMapping("/passengers/{id}")
    public void delete(@PathVariable String id){passengerRepository.deleteById(id);}
    @GetMapping("/Passengers/{email}")
    public PassengerResponseDTO getbyEmail(@PathVariable String email){

        return passengerService.getPassengerByEmail(email);
    }
    @GetMapping("/passengers/{publicId}")
    public PassengerResponseDTO getbyPublicId(@PathVariable String publicId){

        return passengerService.getPassengerByPublicId(publicId);
    }

}
