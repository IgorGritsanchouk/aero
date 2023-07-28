package com.quantum.aero.services;

import com.quantum.aero.domain.Luggage;
import com.quantum.aero.domain.Passenger;
import com.quantum.aero.repositories.LuggageRepository;
import com.quantum.aero.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuggageServiceImpl implements LuggageService{

    @Autowired
    private LuggageRepository luggageRepository;

    public LuggageServiceImpl(LuggageRepository luggageRepository) {
        super();
        this.luggageRepository = luggageRepository;
    }

    @Override
    public Luggage saveLuggage(Luggage luggage) {
        return luggageRepository.save(luggage);
    }


}
