package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.model.Ecology;
import com.korsakov.cityapp.service.EcologyService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/ecologies")
@RequiredArgsConstructor
public class EcologyController {

    private final EcologyService ecologyService;

    @GetMapping
    public List<Ecology> getAllEcologies() {
        return ecologyService.getAllEcologies();
    }

    @GetMapping("/{id}")
    public Ecology getEcologyById(@PathVariable Long id) {
        return ecologyService.getEcologyById(id);
    }

    @PostMapping
    public Ecology createEcology(@RequestBody Ecology ecology) {
        return ecologyService.saveEcology(ecology);
    }

    @DeleteMapping("/{id}")
    public void deleteEcology(@PathVariable Long id) {
        ecologyService.deleteEcology(id);
    }
}
