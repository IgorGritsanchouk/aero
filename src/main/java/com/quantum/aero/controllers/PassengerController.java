package com.quantum.aero.controllers;

import com.quantum.aero.domain.Passenger;
import com.quantum.aero.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        super();
        this.passengerService = passengerService;
    }

    @GetMapping("/passengers")
    public String listPassengers(Model model) {
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers";
    }

    @GetMapping("/passengers/new")
    public String createPassengerForm(Model model) {
        Passenger passenger = new Passenger();
        model.addAttribute("passenger", passenger);
        return "new_passenger";
    }

    @PostMapping("/passengers")
    public String savePassenger(@ModelAttribute("passenger") Passenger passenger) {
        passengerService.savePassenger(passenger);
        return "redirect:/passengers";
    }

    @GetMapping("/passengers/edit/{id}")
    public String editPassengerForm(@PathVariable Long id, Model model) {
        model.addAttribute("passenger", passengerService.getPassengerById(id));
        return "edit-passenger";
    }

    @PostMapping("/passengers/update/{id}")
    public String updatePassenger(@PathVariable Long id,
                                @ModelAttribute("passenger") Passenger passenger,
                                Model model) {

        // get passenger from database by id
        Passenger existingPassenger = passengerService.getPassengerById(id);
        existingPassenger.setId(id);
        existingPassenger.setName(passenger.getName());
        existingPassenger.setPassportNumber(passenger.getPassportNumber());
        existingPassenger.setEmail(passenger.getEmail());

        // save updated passenger object
        passengerService.updatePassenger(existingPassenger);
        return "redirect:/passengers";
    }

    @PostMapping("/passengers/{passportNumber}")
    public String updatePassenger(@PathVariable String passportNumber,
                                  @ModelAttribute("passenger") Passenger passenger,
                                  Model model) {

        // get passenger from database by id
        Passenger existingPassenger = passengerService.getPassengerByPassportNumber(passportNumber);
        existingPassenger.setPassportNumber(passportNumber);
        existingPassenger.setName(passenger.getName());
        existingPassenger.setEmail(passenger.getEmail());

        // save updated passenger object
        passengerService.updatePassenger(existingPassenger);
        return "redirect:/passengers";
    }

    @GetMapping("/passengers/delete/{id}")
    public String deletePassenger(@PathVariable Long id) {
        passengerService.deletePassengerById(id);
        return "redirect:/passengers";
    }
}



