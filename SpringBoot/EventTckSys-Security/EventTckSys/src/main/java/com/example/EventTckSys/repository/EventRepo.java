package com.example.EventTckSys.repository;

import com.example.EventTckSys.model.EventTck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<EventTck, Long> {
    List<EventTck> findByCategoryIgnoreCase(String category);
    List<EventTck> findByEventNameContainingIgnoreCase(String name);
    List<EventTck> findByEventDateBetween(LocalDate start, LocalDate end);
}