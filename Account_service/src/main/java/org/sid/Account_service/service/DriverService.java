package org.sid.Account_service.service;

import org.sid.Account_service.dto.DriverRequestDTO;
import org.sid.Account_service.dto.DriverResponseDTO;

import java.util.List;

public interface DriverService {
    DriverResponseDTO addDriver(DriverRequestDTO driverRequestDTO);
    DriverResponseDTO getDriverById(String id);
    DriverResponseDTO getDriverByPublicId(String publicId);
    DriverResponseDTO getDriverByEmail(String Email);
    DriverResponseDTO updateDriver(String publicId,DriverRequestDTO driverRequestDTO);
    List<DriverResponseDTO> getAllDrivers();

}
