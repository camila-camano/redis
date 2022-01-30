package com.example.restaurante.service;

import com.example.restaurante.model.Restaurante;

import java.util.List;

public interface RestauranteService {

    Restaurante create(Restaurante restaurante);
    List<Restaurante> findAll();
    Restaurante getRestauranteByName(String name);
}
