package com.example.demopersonupdatedservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {
    public void synchronizePersonById(Long personId) {
        log.info("Person with {} id is updated", personId);
    }
}
