package com.olivera.sportradareventlist.service.impl;

import com.olivera.sportradareventlist.model.Event;
import com.olivera.sportradareventlist.repository.EventRepository;
import com.olivera.sportradareventlist.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }


}
