package com.taxi.controller;

import com.taxi.entity.DriverEntity;
import com.taxi.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/drivers")
    public String showDrivers(Model model) {
        List<DriverEntity> drivers = driverRepository.findAll();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }
}
