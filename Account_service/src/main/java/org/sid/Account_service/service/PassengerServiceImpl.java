package org.sid.Account_service.service;

import org.sid.Account_service.dto.PassengerRequestDTO;
import org.sid.Account_service.dto.PassengerResponseDTO;
import org.sid.Account_service.entities.Passenger;
import org.sid.Account_service.mappers.PassengerMapper;
import org.sid.Account_service.repositories.PassengerRepository;
import org.sid.Account_service.restClient.AuthenticationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private AuthenticationRestClient authenticationRestClient;
    @Autowired
    private PassengerMapper passengerMapper;
    @Override
    public PassengerResponseDTO addPassenger(PassengerRequestDTO passengerRequestDTO) {
        Passenger passenger=passengerMapper.toPassenger(passengerRequestDTO);
        Passenger savedPassenger = passengerRepository.save(passenger);
        authenticationRestClient.passengerRegister(passengerRequestDTO);
        return passengerMapper.fromPassenger(savedPassenger);
    }

    @Override
    public PassengerResponseDTO getPassengerById(String id) {
        Passenger passenger=passengerRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        return passengerMapper.fromPassenger(passenger);
    }

    @Override
    public PassengerResponseDTO getPassengerByPublicId(String publicId) {
        Passenger passenger=passengerRepository.findPassengerByPublicId(publicId);
        return passengerMapper.fromPassenger(passenger);
    }

    @Override
    public PassengerResponseDTO getPassengerByEmail(String Email) {
        Passenger passenger=passengerRepository.findPassengerByEmail(Email);
        return passengerMapper.fromPassenger(passenger);
    }

    @Override
    public PassengerResponseDTO updatePassenger(String publicId, PassengerRequestDTO passengerRequestDTO) {
        Passenger passenger= passengerRepository.findPassengerByPublicId(publicId);
        passenger =passengerMapper.update(passenger,passengerRequestDTO);
        passengerRepository.save(passenger);
        return passengerMapper.fromPassenger(passenger);
    }

    @Override
    public List<PassengerResponseDTO> getAllPassengers() {
        return passengerMapper.passengersToPassengerResponseDTOS(passengerRepository.findAll());
    }
}
