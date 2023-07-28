package com.quantum.aero.services;

import com.quantum.aero.domain.Passenger;
import com.quantum.aero.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassengerServiceImpl implements PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository PassengerRepository) {
        super();
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    @Override
    public Passenger getPassengerByPassportNumber(String passportNumber) {
        return passengerRepository.findByPassportNumber(passportNumber);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public void deletePassengerById(Long id) {
        passengerRepository.deleteById(id);
    }
}
