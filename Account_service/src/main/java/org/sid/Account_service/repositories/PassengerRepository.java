package org.sid.Account_service.repositories;

import org.sid.Account_service.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface PassengerRepository extends JpaRepository<Passenger,String> {
    Passenger findPassengerByEmail (String email);
    Passenger findPassengerByPublicId(String publicId);
}
