package com.example.EventTckSys.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventTck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;

    private String category; // music, tech, sports

    private String venue;

    private Double price;

    private Integer availableTickets;

    private LocalDate eventDate;

}