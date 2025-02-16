package com.prem.library.events;

import java.time.LocalDate;

public record Event(
        int id,
        String name,
        Organizer organizer,
        Venue venue,
        LocalDate startDate,
        LocalDate endDate) {
}
