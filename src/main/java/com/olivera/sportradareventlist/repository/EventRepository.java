package com.olivera.sportradareventlist.repository;

import com.olivera.sportradareventlist.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
