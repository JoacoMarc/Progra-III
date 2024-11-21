package com.edutec.demoneo4j.repository;

import com.edutec.demoneo4j.entities.Pelicula;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface PeliculaRepositorio extends ReactiveNeo4jRepository<Pelicula, String> {
    Mono<Pelicula> findOneByTitulo(String titulo);
}