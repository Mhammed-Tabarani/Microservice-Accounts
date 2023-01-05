package org.sid.Account_service.web;

import org.sid.Account_service.dto.DriverRequestDTO;
import org.sid.Account_service.dto.DriverResponseDTO;
import org.sid.Account_service.entities.Driver;
import org.sid.Account_service.repositories.DriverRepository;
import org.sid.Account_service.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverRestController {
    private DriverRepository driverRepository;
    private DriverService driverService;

    public DriverRestController(DriverRepository driverRepository, DriverService driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    //public List<DriverResponseDTO> drivers(){return driverService.getAllDrivers();}
    public List<Driver> drivers(){return driverRepository.findAll();}

    @GetMapping("/drivers/{id}")
    public DriverResponseDTO getDriverByID(@PathVariable String id){
        return driverService.getDriverById(id);
    }
    @PostMapping("/drivers")
    public DriverResponseDTO save(@RequestBody DriverRequestDTO driverRequestDTO){

        return driverService.addDriver(driverRequestDTO);
    }

    @PutMapping("/drivers/{id}")
    public DriverResponseDTO update(@PathVariable String id , @RequestBody DriverRequestDTO driverRequestDTO){

        return driverService.updateDriver(id,driverRequestDTO);
    }
    @DeleteMapping("/drivers/{id}")
    public void delete(@PathVariable String id){driverRepository.deleteById(id);}

    @GetMapping("/drivers/{email}")
    public DriverResponseDTO getbyEmail(@PathVariable String email){

        return driverService.getDriverByEmail(email);
    }

    @GetMapping("/drivers/{publicId}")
    public DriverResponseDTO getByPublicId(@PathVariable String publicId){

        return driverService.getDriverByPublicId(publicId);
    }


}
