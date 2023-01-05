package org.sid.Account_service.service;

import org.sid.Account_service.dto.DriverRequestDTO;
import org.sid.Account_service.dto.DriverResponseDTO;
import org.sid.Account_service.entities.Driver;
import org.sid.Account_service.mappers.DriverMapper;
import org.sid.Account_service.repositories.DriverRepository;
import org.sid.Account_service.restClient.AuthenticationRestClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;
    private DriverMapper driverMapper;
    private AuthenticationRestClient authenticationRestClient;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper, AuthenticationRestClient authenticationRestClient) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
        this.authenticationRestClient = authenticationRestClient;
    }

    @Override
    public DriverResponseDTO addDriver(DriverRequestDTO driverRequestDTO) {
        Driver driver = driverMapper.toDriver(driverRequestDTO);
        Driver savedDriver = driverRepository.save(driver);
        authenticationRestClient.driverRegister(driverRequestDTO);
        return driverMapper.fromDriver(savedDriver);
    }

    @Override
    public DriverResponseDTO getDriverById(String id) {
        Driver driver=driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        return driverMapper.fromDriver(driver);
    }

    @Override
    public DriverResponseDTO getDriverByPublicId(String id) {
        Driver driver=driverRepository.findPDriverByPublicId(id);
        return driverMapper.fromDriver(driver);
    }

    @Override
    public DriverResponseDTO getDriverByEmail(String Email) {
        Driver driver=driverRepository.findDriverByEmail(Email);
        return driverMapper.fromDriver(driver);
    }

    @Override
    public DriverResponseDTO updateDriver(String publicId, DriverRequestDTO driverRequestDTO) {

        Driver driver= driverRepository.findPDriverByPublicId(publicId);

        driver =driverMapper.update(driver,driverRequestDTO);
        driverRepository.save(driver);
        return driverMapper.fromDriver(driver);
    }

    @Override
    public List<DriverResponseDTO> getAllDrivers() {

        return driverMapper.driversToDriverResponseDTOS(driverRepository.findAll());
    }
}
