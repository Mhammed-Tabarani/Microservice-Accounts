package org.sid.Account_service;

import org.sid.Account_service.entities.Driver;
import org.sid.Account_service.entities.Passenger;
import org.sid.Account_service.repositories.DriverRepository;
import org.sid.Account_service.repositories.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PassengerRepository passengerRepository , DriverRepository driverRepository){
		return args -> {

			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),new Date(),"Mhammed",19,"mhammed.tabarani@gmail.com","0777180558"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),new Date(),"Siham",19,"SIHAM.SIHAM@gmail.com","0777180558"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),new Date(),"Aya",19,"AYA.AYA@gmail.com","0777180558"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),new Date(),"ALI",19,"ALI.ALI@gmail.com","0777180558"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),new Date(),"hamid",19,"hamid.hamid@gmail.com","0777180558"));

			driverRepository.save(new Driver(UUID.randomUUID().toString(),new Date(),"Mhammed",19,"mhammed.tabarani@gmail.com","0777180558",UUID.randomUUID().toString()));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),new Date(),"Siham",19,"SIHAM.SIHAM@gmail.com","0777180558",UUID.randomUUID().toString()));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),new Date(),"Aya",19,"AYA.AYA@gmail.com","0777180558",UUID.randomUUID().toString()));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),new Date(),"ALI",19,"ALI.ALI@gmail.com","0777180558",UUID.randomUUID().toString()));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),new Date(),"hamid",19,"hamid.hamid@gmail.com","0777180558",UUID.randomUUID().toString()));


		};
	}
}
