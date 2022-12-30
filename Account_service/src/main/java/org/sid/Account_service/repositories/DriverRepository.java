package org.sid.Account_service.repositories;

import org.sid.Account_service.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,String> {
}
