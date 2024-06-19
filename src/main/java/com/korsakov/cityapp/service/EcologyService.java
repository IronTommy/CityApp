package com.korsakov.cityapp.service;

import com.korsakov.cityapp.model.Ecology;
import com.korsakov.cityapp.repository.EcologyRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EcologyService {

    private final EcologyRepository ecologyRepository;

    public List<Ecology> getAllEcologies() {
        return ecologyRepository.findAll();
    }

    public Ecology getEcologyById(Long id) {
        return ecologyRepository.findById(id).orElse(null);
    }

    public Ecology saveEcology(Ecology ecology) {
        return ecologyRepository.save(ecology);
    }

    public void deleteEcology(Long id) {
        ecologyRepository.deleteById(id);
    }
}
