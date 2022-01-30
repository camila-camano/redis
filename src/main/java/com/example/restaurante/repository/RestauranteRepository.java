package com.example.restaurante.repository;

import com.example.restaurante.model.Restaurante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {

    Restaurante findRestauranteByName(String name);

}
