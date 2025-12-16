package com.example.EventTckSys.service;

import com.example.EventTckSys.model.EventTck;
import com.example.EventTckSys.repository.EventRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
//service implementation
@Service
public class ServiceImplm implements EventService {

    private final EventRepo eventRepo;

    public ServiceImplm(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public EventTck createEvent(EventTck event) {
        return eventRepo.save(event);
    }

    @Override
    public List<EventTck> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Optional<EventTck> getEventById(Long id) {
        return eventRepo.findById(id);
    }
    //updating the data
    @Override
    public EventTck updateEvent(Long id, EventTck event) {
        return eventRepo.findById(id).map(existing -> {
            existing.setEventName(event.getEventName());
            existing.setCategory(event.getCategory());
            existing.setVenue(event.getVenue());
            existing.setPrice(event.getPrice());
            existing.setAvailableTickets(event.getAvailableTickets());
            existing.setEventDate(event.getEventDate());
            return eventRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);
    }
    //finding by category
    @Override
    public List<EventTck> findByCategory(String category) {
        return eventRepo.findByCategoryIgnoreCase(category);
    }
    //finding by name
    @Override
    public List<EventTck> searchByName(String name) {
        return eventRepo.findByEventNameContainingIgnoreCase(name);
    }
    //finding events between dates
    @Override
    public List<EventTck> findEventsBetween(LocalDate start, LocalDate end) {
        return eventRepo.findByEventDateBetween(start, end);
    }
}