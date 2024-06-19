package com.korsakov.cityapp.repository;

import com.korsakov.cityapp.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Long> {
}
