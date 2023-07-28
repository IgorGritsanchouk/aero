package com.quantum.aero.bootstrap;

import com.quantum.aero.domain.Flight;
import com.quantum.aero.domain.Luggage;
import com.quantum.aero.domain.Passenger;
import com.quantum.aero.repositories.FlightRepository;
import com.quantum.aero.repositories.LuggageRepository;
import com.quantum.aero.repositories.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;
    private final LuggageRepository luggageRepository;

    public BootStrapData(PassengerRepository passengerRepository,
                         FlightRepository flightRepository,
                         LuggageRepository luggageRepository) {
        this.passengerRepository= passengerRepository;
        this.flightRepository= flightRepository;
        this.luggageRepository = luggageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("... START Boot strap data ...");

        Passenger passenger1= new Passenger();
        passenger1.setName("Martine");
        passenger1.setEmail("martine@gmail.com");
        passenger1.setPassportNumber("UK-X123ky76");
        //passengerRepository.save(passenger1);

        Luggage luggage1= new Luggage();
        luggage1.setSize("standart");
        luggage1.setPassenger(passenger1);
        Luggage luggage2= new Luggage();
        luggage2.setSize("ovarsized");
        luggage2.setPassenger(passenger1);
        ArrayList<Luggage> passenger1Luggage= new ArrayList<Luggage>();
        passenger1Luggage.add(luggage1);
        passenger1Luggage.add(luggage2);

        Flight flight1= new Flight();
        flight1.setDeparture("LHR");
        flight1.setDestination("PCD");
        ArrayList<Passenger> flight1Passengers= new ArrayList<Passenger>();
        flight1Passengers.add(passenger1);
 //       flightRepository.save(flight1);

        Set<Flight> flightsSet= new HashSet<>();
        flightsSet.add(flight1);

        passenger1.setFlights(flightsSet);
        passenger1.setLuggageLst(passenger1Luggage);
        passengerRepository.save(passenger1);

        System.out.println("... END Boot strap data ...");

    }
}
