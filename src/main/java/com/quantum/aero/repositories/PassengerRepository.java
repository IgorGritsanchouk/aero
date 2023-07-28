package com.quantum.aero.repositories;

import com.quantum.aero.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByPassportNumber(String passportNumber);
}
