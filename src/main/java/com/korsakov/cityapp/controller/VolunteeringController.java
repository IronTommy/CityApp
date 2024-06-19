package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.model.Volunteering;
import com.korsakov.cityapp.service.VolunteeringService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/volunteerings")
@RequiredArgsConstructor
public class VolunteeringController {

    private final VolunteeringService volunteeringService;

    @GetMapping
    public List<Volunteering> getAllVolunteerings() {
        return volunteeringService.getAllVolunteerings();
    }

    @GetMapping("/{id}")
    public Volunteering getVolunteeringById(@PathVariable Long id) {
        return volunteeringService.getVolunteeringById(id);
    }

    @PostMapping
    public Volunteering createVolunteering(@RequestBody Volunteering volunteering) {
        return volunteeringService.saveVolunteering(volunteering);
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteering(@PathVariable Long id) {
        volunteeringService.deleteVolunteering(id);
    }
}
