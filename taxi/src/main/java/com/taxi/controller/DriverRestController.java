package com.taxi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taxi.entity.DriverEntity;
import com.taxi.repository.DriverRepository;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {

    private final DriverRepository repo;

    public DriverRestController(DriverRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<DriverEntity> listAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
