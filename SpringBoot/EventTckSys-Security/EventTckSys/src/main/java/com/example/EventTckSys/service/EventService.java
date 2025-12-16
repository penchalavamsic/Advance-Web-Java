package com.example.EventTckSys.service;

import com.example.EventTckSys.model.EventTck;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {
    EventTck createEvent(EventTck event);
    List<EventTck> getAllEvents();
    Optional<EventTck> getEventById(Long id);
    EventTck updateEvent(Long id, EventTck event);
    void deleteEvent(Long id);

    List<EventTck> findByCategory(String category);
    List<EventTck> searchByName(String name);
    List<EventTck> findEventsBetween(LocalDate start, LocalDate end);
}