package com.olivera.sportradareventlist.controller;

import com.olivera.sportradareventlist.model.Event;
import com.olivera.sportradareventlist.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // handler method to handle list of events and return mode and view
    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute( "events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/events/new")
    public String createEventForm(Model model) {

        //create event object to hold event form data
        Event event = new Event();
        model.addAttribute("event", event);
        return "create_event";
    }

    @PostMapping("/events")
    public String saveEvent (@ModelAttribute("event") Event event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/edit/{id}")
    public String editEventForm(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "edit_event";
    }

    @PostMapping("/events/{id}")
    public String updateEvent (@PathVariable Long id,
                               @ModelAttribute("event") Event event,
                               Model model) {
        //get event from database by id
        Event existingEvent = eventService.getEventById(id);
        existingEvent.setId(id);
        existingEvent.setDate(event.getDate());
        existingEvent.setSport(event.getSport());
        existingEvent.setTeam(event.getTeam());


        //save updated student object
        eventService.updateEvent(existingEvent);
        return "redirect:/events";
    }

    // handler method to handle delete event request

    @GetMapping("/events/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return "redirect:/events";
    }

}
