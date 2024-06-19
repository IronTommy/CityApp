package com.korsakov.cityapp.repository;

import com.korsakov.cityapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
