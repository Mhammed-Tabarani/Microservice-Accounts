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

			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"Mhammed","Tabarani","mhammed.tabarani@gmail.com",new Date(),"ooooooooooooooooooooooooooooooooo","0000000000","WA28888"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"Ayyoub","Ayyoub","ayyoub@gmail.com",new Date(),"aaaaaaaaaaaaaaaaaaaaaaaaaaa","1111111111","WA28888"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"Amine","Amine","amine@gmail.com",new Date(),"hhhhhhhhhhhhhhhhhhhhhhhh","22222222222","WA28888"));
			passengerRepository.save(new Passenger(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"raziq","raziq","raziq@gmail.com",new Date(),"zzzzzzzzzzzzzzzzzzzzzzzzzz","3333333333","WA28888"));

			driverRepository.save(new Driver(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"Mhammed","Tabarani","mhammed.tabarani@gmail.com",new Date(),"ooooooooooooooooooooooooooooooooo","0000000000","WA28888","zzzzzzzzzzzzzzzzzzz"));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"Ayyoub","Ayyoub","ayyoub@gmail.com",new Date(),"aaaaaaaaaaaaaaaaaaaaaaaaaaa","1111111111","WA28888","zzzzzzzzzzzzzzzzzzz"));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"Amine","Amine","amine@gmail.com",new Date(),"hhhhhhhhhhhhhhhhhhhhhhhh","22222222222","WA28888","zzzzzzzzzzzzzzzzzzz"));
			driverRepository.save(new Driver(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"raziq","raziq","raziq@gmail.com",new Date(),"zzzzzzzzzzzzzzzzzzzzzzzzzz","3333333333","WA28888","zzzzzzzzzzzzzzzzzzz"));

		};
	}
}
