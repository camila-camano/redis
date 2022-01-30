package com.example.restaurante.controller;

import com.example.restaurante.model.Restaurante;
import com.example.restaurante.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private  final RestauranteService service;

    @GetMapping("/example")
    public String getExample(){
        log.info("GET example recibido.");
        return "GET example recibido.";
    }


    @GetMapping("/getall")
    public List<Restaurante> getAllRestaurante() {
        log.info("GET obtener restaurante por el nombre");
        return service.findAll();
    }

    @GetMapping("/getbyname")
    public Restaurante getRestauranteByName(@RequestParam String name){
        log.info("GET restaurante por nombre");
        return service.getRestauranteByName(name);
    }

    @PostMapping("/post")
    public Restaurante createMessage(@RequestBody Restaurante restaurante) {
        log.info("POST crear restaurante");
        return service.create(restaurante);
    }



}
