package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.model.Transport;
import com.korsakov.cityapp.service.TransportService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/transports")
@RequiredArgsConstructor
public class TransportController {

    private final TransportService transportService;

    @GetMapping
    public List<Transport> getAllTransports() {
        return transportService.getAllTransports();
    }

    @GetMapping("/{id}")
    public Transport getTransportById(@PathVariable Long id) {
        return transportService.getTransportById(id);
    }

    @PostMapping
    public Transport createTransport(@RequestBody Transport transport) {
        return transportService.saveTransport(transport);
    }

    @DeleteMapping("/{id}")
    public void deleteTransport(@PathVariable Long id) {
        transportService.deleteTransport(id);
    }
}
