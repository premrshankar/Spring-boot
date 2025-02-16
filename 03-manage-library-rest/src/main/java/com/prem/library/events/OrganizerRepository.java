package com.prem.library.events;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepository {

    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Nishu Gallery", "Nishu Gallery Technology Corporation"),
            new Organizer(102, "DEV Rock", "DEV Rock Sports Equipment"));

    public List<Organizer> findAll() {
        return organizers;
    }
}
