package com.korsakov.cityapp.repository;

import com.korsakov.cityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
