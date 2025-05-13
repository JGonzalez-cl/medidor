package com.cebem.medidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.repositories.SuperheroRepository;

@Controller
public class SuperheroController {

    private final SuperheroRepository superheroRepository;

    public SuperheroController(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    @GetMapping("/random-hero")
    public String getRandomSuperhero(Model model) {
        Superhero superhero = superheroRepository.getRandomSuperhero();
        model.addAttribute("hero", superhero);
        return "hero-card"; // Nombre de la plantilla Thymeleaf
    }
}
