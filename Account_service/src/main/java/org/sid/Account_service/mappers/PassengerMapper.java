package org.sid.Account_service.mappers;

import org.sid.Account_service.dto.DriverResponseDTO;
import org.sid.Account_service.dto.PassengerRequestDTO;
import org.sid.Account_service.dto.PassengerResponseDTO;
import org.sid.Account_service.entities.Driver;
import org.sid.Account_service.entities.Passenger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PassengerMapper {
    public PassengerResponseDTO fromPassenger(Passenger passenger){
        PassengerResponseDTO passengerResponseDTO=new PassengerResponseDTO();
        System.out.println(passenger);
        BeanUtils.copyProperties(passenger,passengerResponseDTO);
        return passengerResponseDTO;
    }
    public Passenger toPassenger(PassengerRequestDTO passengerRequestDTO){
        Passenger passenger=new Passenger();
        BeanUtils.copyProperties(passengerRequestDTO,passenger);
        passenger.setId(UUID.randomUUID().toString());
        passenger.setPublicId(UUID.randomUUID().toString());
        return passenger;
    }
    public Passenger update(Passenger passenger , PassengerRequestDTO passengerRequestDTO){

        BeanUtils.copyProperties(passengerRequestDTO,passenger);
        return passenger;
    }
    public List<PassengerResponseDTO> passengersToPassengerResponseDTOS(List<Passenger> passengers){
        List<PassengerResponseDTO> passengerResponseDTOS = null;
        for (Passenger p:passengers
        ) { passengerResponseDTOS.add(fromPassenger(p));

        }
        return passengerResponseDTOS;
    }
}
