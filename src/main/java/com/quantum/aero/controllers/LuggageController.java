package com.quantum.aero.controllers;

import com.quantum.aero.domain.Luggage;
import com.quantum.aero.domain.Passenger;
import com.quantum.aero.services.LuggageService;
import com.quantum.aero.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LuggageController {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private LuggageService luggageService;

    @GetMapping("/luggage-items/new/{id}")
    public String createLuggageForm(@PathVariable Long id,
                                    Model model) {
        Luggage luggage = new Luggage();
        Passenger existingPassenger = passengerService.getPassengerById(id);
        existingPassenger.getLuggageLst().add(luggage);
        luggage.setPassenger(existingPassenger);
        model.addAttribute("luggage", luggage);
        return "new-luggage";
    }

    @PostMapping("/luggage-items/save/{id}")
    public String saveLuggage(@PathVariable Long id,
                              @ModelAttribute("luggage") Luggage luggage,
                              Model model) {

        // get passenger from database by id
//        Passenger existingPassenger = passengerService.getPassengerById(id);
//        existingPassenger.getLuggageLst().add(luggage);
//        luggage.setPassenger(existingPassenger);
        System.out.println("xxx passenger id xxxx : " + id);

        if(luggage.getPassenger().getId() != null) {
            System.out.println(luggage.getPassenger().getId());
        }

        // save updated passenger object
        luggageService.saveLuggage(luggage);

        List<Passenger> passengers= passengerService.getAllPassengers();
        model.addAttribute("passengers", passengers);
        return "redirect:/passengers";
    }

//    @GetMapping("/luggage/new/{passenger_id}")
//    public String editPassengerForm(@PathVariable Long passenger_id, Model model) {
//        model.addAttribute("passenger", passengerService.getPassengerById(id));
//        return "edit-passenger";
//    }

}
