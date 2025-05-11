package com.taxi.controller;

import com.taxi.entity.PassengerEntity;
import com.taxi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PassengerController {

    private final PassengerRepository passengerRepository;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping("/passengers")
    public String listPassengers(Model model) {
        List<PassengerEntity> passengers = passengerRepository.findAll();
        model.addAttribute("passengers", passengers);
        return "passengers";
    }
}
