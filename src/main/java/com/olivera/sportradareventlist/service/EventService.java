package com.olivera.sportradareventlist.service;

import com.olivera.sportradareventlist.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event saveEvent(Event event);

    Event getEventById(Long id);

    Event updateEvent(Event event);

    void deleteEventById(Long id);
}
