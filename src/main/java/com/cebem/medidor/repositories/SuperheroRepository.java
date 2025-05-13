package com.cebem.medidor.repositories;

import org.springframework.stereotype.Repository;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.services.SuperheroService;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SuperheroRepository {

    private final SuperheroService superheroService;

    public Superhero getRandomSuperhero() {
        return superheroService.getRandomSuperhero();
    }
}
