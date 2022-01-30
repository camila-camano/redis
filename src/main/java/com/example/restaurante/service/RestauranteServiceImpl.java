package com.example.restaurante.service;


import com.example.restaurante.cache.CacheClient;
import com.example.restaurante.model.Restaurante;
import com.example.restaurante.repository.RestauranteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service

@Slf4j
@RequiredArgsConstructor
public class RestauranteServiceImpl implements  RestauranteService{
    private final RestauranteRepository repository;
    private final CacheClient<Restaurante> cache;

    public Restaurante create(Restaurante restaurante){
        try {
            var data = repository.save(restaurante);
            return saveMessageInCache(data);
        } catch (JsonProcessingException e) {
            log.error("Error convirtiendo resturante a string", e);
        }
        return restaurante;
    }

    @Override
    public List<Restaurante> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),
                false).collect(Collectors.toList());
    }

    private Restaurante saveMessageInCache(Restaurante restaurante) throws JsonProcessingException {
        return cache.save(restaurante.getId().toString(), restaurante);
    }

}
