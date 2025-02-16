package com.prem.library.events;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    private final List<Event> events = List.of(
            new Event(501, "Nishu Gallery Tech Conference",
                    new Organizer(101, "Nishu Gallery", "Nishu Gallery Technology Corporation"),
                    new Venue(201, "Nishu Gallery Main Office", "Test Street 325", "Delhi", "India"),
                    LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 4)),
            new Event(502, "Nishu Gallery Developer Day",
                    new Organizer(101, "Nishu Gallery", "Nishu Gallery Technology Corporation"),
                    new Venue(201, "Globomatics Main Office", "Test Street 325", "Noida", "India"),
                    LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 10)),
            new Event(503, "DEV Rock New Products Day",
                    new Organizer(102, "DEV Rock", "DEV Rock Sports Equipment"),
                    new Venue(202, "Sea View Hotel", "Mahakumbh", "Prayagraj", "India"),
                    LocalDate.of(2024, 2, 29), LocalDate.of(2024, 2, 29)));

    public List<Event> findByOrganizerId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }
}
