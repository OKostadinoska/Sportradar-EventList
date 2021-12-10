package com.olivera.sportradareventlist;

import com.olivera.sportradareventlist.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportradarEventListApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SportradarEventListApplication.class, args);
    }

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void run(String...args) throws Exception{

    }
}
