package com.prem.library.events;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final List<Venue> venues = List.of(
            new Venue(201, "Nishu Gallery Main Office", "Test Street 325", "New York", "USA"),
            new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA"));

    public Optional<Venue> findById(int id) {
        return venues.stream().filter(venue -> venue.id() == id).findAny();
    }
}
