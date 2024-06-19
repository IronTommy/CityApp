package com.korsakov.cityapp.repository;

import com.korsakov.cityapp.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
