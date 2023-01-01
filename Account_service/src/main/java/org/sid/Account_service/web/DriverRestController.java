package org.sid.Account_service.web;

import org.sid.Account_service.entities.Driver;
import org.sid.Account_service.entities.Passenger;
import org.sid.Account_service.repositories.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class DriverRestController {
    private DriverRepository driverRepository;

    public DriverRestController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/drivers")
    public List<Driver> drivers(){return driverRepository.findAll();}

    @GetMapping("/drivers/{id}")
    public Driver driver(@PathVariable String id){
        return driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/drivers")
    public Driver save(@RequestBody Driver driver){
        if(driver.getId()==null) driver.setId(UUID.randomUUID().toString());
        return driverRepository.save(driver);
    }

    @PutMapping("/drivers/{id}")
    public Driver update(@PathVariable String id , Driver driver){
        Driver driver1= driverRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s bot found",id)));
        return driverRepository.save(driver);
    }
    @DeleteMapping("/drivers/{id}")
    public void delete(@PathVariable String id){driverRepository.deleteById(id);}

    @GetMapping("/Passengers/{email}")
    public Driver getbyEmail(@PathVariable String email){

        return driverRepository.findDriverByEmail(email);
    }


}
