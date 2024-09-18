package com.quantum.aero;

import com.quantum.aero.domain.Flight;
import com.quantum.aero.domain.Luggage;
import com.quantum.aero.domain.Passenger;
import com.quantum.aero.repositories.FlightRepository;
import com.quantum.aero.repositories.PassengerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    void testSavePassenger() {

        Passenger passenger1 = new Passenger();
        passenger1.setName("Martine");
        passenger1.setEmail("martine@gmail.com");
        passenger1.setPassportNumber("UK-X123k-philip");

        Luggage luggage1 = new Luggage();
        luggage1.setSize("standart");
        luggage1.setPassenger(passenger1);
        Luggage luggage2 = new Luggage();
        luggage2.setSize("ovarsized");
        luggage2.setPassenger(passenger1);
        ArrayList<Luggage> passenger1Luggage = new ArrayList<Luggage>();
        passenger1Luggage.add(luggage1);
        passenger1Luggage.add(luggage2);

        Flight flight1 = new Flight();
        flight1.setDeparture("LHR");
        flight1.setDestination("PCD");
        ArrayList<Passenger> flight1Passengers = new ArrayList<Passenger>();
        flight1Passengers.add(passenger1);
        //flightRepository.save(flight1);

        Set<Flight> flights= new HashSet();
        flights.add(flight1);
        passenger1.setFlights(flights);
        passenger1.setLuggageLst(passenger1Luggage);
        passengerRepository.save(passenger1);
    }

    //@Test
    void testUpdatePassenger() {
        Passenger passenger = passengerRepository.findById(1L).get();
        passenger.setEmail("philip.courtois@gmail.com");
        passengerRepository.save(passenger);
    }

    //@Test
    void testGetAllPassengers() {

        List<Passenger> passengers = passengerRepository.findAll();

        passengers.forEach((p) -> {
            System.out.println("passenger id :: " + p.getId());
            p.getLuggageLst().forEach((luggage -> {
                System.out.println("luggage id :: " + luggage.getId());
            }));
        });
    }

    //@Test
    void testFindPassengerByPassportNumber() {

        Passenger passenger = passengerRepository.findByPassportNumber("UK-X123k-philip");
        System.out.println("xxxxx  passenger id :: "+ passenger.getId());

        // add fetch type as EAGER
        passenger.getLuggageLst().forEach((luggage) -> {
            System.out.println("luggage id :: "+ luggage.getId());
        });

        //passengerRepository.deleteById(2L);
    }

    //@Test
    void testDeletePassenger() {
        passengerRepository.deleteById(2L);
    }
}


