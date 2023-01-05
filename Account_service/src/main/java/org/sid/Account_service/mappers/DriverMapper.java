package org.sid.Account_service.mappers;

import org.sid.Account_service.dto.DriverRequestDTO;
import org.sid.Account_service.dto.DriverResponseDTO;
import org.sid.Account_service.entities.Driver;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DriverMapper {

    public DriverResponseDTO fromDriver(Driver driver){
        DriverResponseDTO driverResponseDTO=new DriverResponseDTO();
        BeanUtils.copyProperties(driver,driverResponseDTO);
        return driverResponseDTO;
    }
    public Driver toDriver(DriverRequestDTO driverRequestDTO){
        Driver driver=new Driver();
        BeanUtils.copyProperties(driverRequestDTO,driver);
        driver.setId(UUID.randomUUID().toString());
        driver.setPublicId(UUID.randomUUID().toString());
        return driver;
    }

    public Driver update(Driver driver ,DriverRequestDTO driverRequestDTO){

        Driver driver1= new Driver();
        BeanUtils.copyProperties(driverRequestDTO,driver1);

        return driver;
    }
    
    public List<DriverResponseDTO> driversToDriverResponseDTOS(List<Driver> drivers){
        List<DriverResponseDTO> driverResponseDTOS = new ArrayList<DriverResponseDTO>();
        for (Driver d:drivers
             ) { driverResponseDTOS.add(fromDriver(d));

        }
        return driverResponseDTOS;
    }


}
