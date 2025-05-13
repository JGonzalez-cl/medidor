package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.models.Measure;
import com.cebem.medidor.repositories.MeasureRepository;
import com.cebem.medidor.repositories.SuperheroRepository;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class PruebaController {

    // http://localhost:8080/saluda

    @GetMapping("/saluda")
    public String saluda() {
        return "Hola desde el backend!";
    }

    @GetMapping("/")
    public String Fin() {
        return "Aqui no hay na";
    }

    @GetMapping("/palindromo/{word}")
    public String palindromo(@PathVariable String word) {
        String inverse = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(inverse) ? "Si es un palindromo" : "No es palindromo";
    }

    @GetMapping("/palin")
    public String palin(@RequestParam String palabra, @RequestParam String valor) {

        String inverso = new StringBuilder(palabra).reverse().toString();

        return palabra.equalsIgnoreCase(inverso) ? "Es un palindromo" : " No es un palindromo";

    }

    @PostMapping("/saveOnDisk")
    public String login(@RequestParam String user, @RequestParam String passwd) {
        System.out.println("body" + user + passwd);
        return "hola";
    }

    // Inyeccion de dependencias
    private final MeasureRepository sensorDataRepository;

    @PostMapping("/saveMeasure")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSensorData(@RequestBody Measure sensorData) {
        sensorDataRepository.save(sensorData);
    }

    // Obtener todas las mediciones que se han guardado en la BD
    @GetMapping("/getAllMeasures")
    public Iterable<Measure> getAllMeasures() {
        return sensorDataRepository.findAll();
    }

    // otra forma de hacerlo pero mas fea
    @GetMapping("/getMeasures")
    public ResponseEntity<List<Measure>> getAllSensorData() {
        List<Measure> sensorData = sensorDataRepository.findAll();
        return ResponseEntity.ok(sensorData);
    }

    // Ejercicio 4 endpoints

    @GetMapping("rickandmorty/random")
    public String getRandomRickAndMorty() {
        String url = "https://rickandmortyapi.com/api/character/random";
        return url;
    }

    private final SuperheroRepository superheroRepository;

    @GetMapping("/hero")
    public String getRandomSuperhero(Model model) {
        model.addAttribute("hero", superheroRepository.getRandomSuperhero());
        return "hero-card";
    }

}