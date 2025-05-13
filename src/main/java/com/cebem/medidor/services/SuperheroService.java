package com.cebem.medidor.services;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.Superhero;

@Service
public class SuperheroService {
    private static final String API_TOKEN = "e15a4f9fecb044853997e90bfe6ea4c2"; // Sustituye con tu token
    private static final String BASE_URL = "https://superheroapi.com/api/" + API_TOKEN + "/";
    private static final int MAX_ID = 731;

    private final RestTemplate restTemplate = new RestTemplate();
    private final Random random = new Random();

    public Superhero getRandomSuperhero() {
        int id = random.nextInt(MAX_ID) + 1;
        String url = BASE_URL + id;
        return restTemplate.getForObject(url, Superhero.class);
    }
}
