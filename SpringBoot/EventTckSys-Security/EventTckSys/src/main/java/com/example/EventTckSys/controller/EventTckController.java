package com.example.EventTckSys.controller;

import com.example.EventTckSys.model.EventTck;
import com.example.EventTckSys.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventTckController {

    private final EventService eventService;

    public EventTckController(EventService eventService) {
        this.eventService = eventService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<EventTck> getAll() {
        return eventService.getAllEvents();
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<EventTck> getById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/search")
    public List<EventTck> searchByName(@RequestParam String name) {
        return eventService.searchByName(name);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/category")
    public List<EventTck> byCategory(@RequestParam String category) {
        return eventService.findByCategory(category);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/this-week")
    public List<EventTck> eventsThisWeek() {
        LocalDate now = LocalDate.now();
        LocalDate start = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate end = start.plusDays(6);
        return eventService.findEventsBetween(start, end);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/this-month")
    public List<EventTck> eventsThisMonth() {
        LocalDate now = LocalDate.now();
        LocalDate start = now.withDayOfMonth(1);
        LocalDate end = now.with(TemporalAdjusters.lastDayOfMonth());
        return eventService.findEventsBetween(start, end);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public ResponseEntity<EventTck> createEvent(@Valid @RequestBody EventTck event) {
        EventTck created = eventService.createEvent(event);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<EventTck> updateEvent(@PathVariable Long id, @Valid @RequestBody EventTck event) {
        try {
            EventTck updated = eventService.updateEvent(id, event);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}