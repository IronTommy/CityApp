package com.korsakov.cityapp.repository;

import com.korsakov.cityapp.model.Volunteering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteeringRepository extends JpaRepository<Volunteering, Long> {
}
