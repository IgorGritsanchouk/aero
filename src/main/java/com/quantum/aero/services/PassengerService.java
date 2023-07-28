package com.quantum.aero.services;

import com.quantum.aero.domain.Passenger;
import java.util.List;

public interface PassengerService {

    List<Passenger> getAllPassengers();

    Passenger savePassenger(Passenger passenger);

    Passenger getPassengerById(Long id);

    Passenger getPassengerByPassportNumber(String passportNumber);

    Passenger updatePassenger(Passenger passenger);

    void deletePassengerById(Long id);

}


