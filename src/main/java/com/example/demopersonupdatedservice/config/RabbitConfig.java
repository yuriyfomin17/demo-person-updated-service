package com.example.demopersonupdatedservice.config;

import com.example.demopersonupdatedservice.event.PersonUpdatedEvent;
import com.example.demopersonupdatedservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class RabbitConfig {
    private final PersonService personService;
    @Bean
    public Consumer<PersonUpdatedEvent> personUpdatedEventConsumer(){
        return personUpdatedEvent -> {
            log.info("Received an event: {}", personUpdatedEvent);
            personService.synchronizePersonById(personUpdatedEvent.id());
        };
    }
}
