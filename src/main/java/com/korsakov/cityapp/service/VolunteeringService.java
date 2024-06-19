package com.korsakov.cityapp.service;

import com.korsakov.cityapp.model.Volunteering;
import com.korsakov.cityapp.repository.VolunteeringRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteeringService {

    private final VolunteeringRepository volunteeringRepository;

    public List<Volunteering> getAllVolunteerings() {
        return volunteeringRepository.findAll();
    }

    public Volunteering getVolunteeringById(Long id) {
        return volunteeringRepository.findById(id).orElse(null);
    }

    public Volunteering saveVolunteering(Volunteering volunteering) {
        return volunteeringRepository.save(volunteering);
    }

    public void deleteVolunteering(Long id) {
        volunteeringRepository.deleteById(id);
    }
}
