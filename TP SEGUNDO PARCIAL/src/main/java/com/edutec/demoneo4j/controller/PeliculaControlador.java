package com.edutec.demoneo4j.controller;

import com.edutec.demoneo4j.entities.Grafo;
import com.edutec.demoneo4j.entities.Pelicula;
import com.edutec.demoneo4j.repository.PeliculaRepositorio;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaControlador {

    private final PeliculaRepositorio peliculaRepo;

    public PeliculaControlador(PeliculaRepositorio peliculaRepo) {
        this.peliculaRepo = peliculaRepo;
    }

    /**
     * Crea una nueva película o actualiza una existente.
     *
     * @param pelicula Nueva entidad de película a guardar.
     * @return Mono con la entidad de película guardada.
     */
    @PutMapping
    public Mono<Pelicula> guardarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaRepo.save(pelicula);
    }

    /**
     * Obtiene todas las películas en formato de flujo de eventos.
     *
     * @return Flux con todas las entidades de películas.
     */
    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Pelicula> listarPeliculas() {
        return peliculaRepo.findAll();
    }

    /**
     * Genera una representación del grafo de películas.
     *
     * @return Mono con la representación en String del grafo.
     */
    @GetMapping("/grafo")
    public Mono<String> obtenerGrafo() {
        return peliculaRepo.findAll()
                .collectList()
                .map(listaPeliculas -> {
                    Grafo grafo = new Grafo(listaPeliculas);
                    return grafo.toString();
                });
    }

    /**
     * Realiza un recorrido BFS en el grafo de películas.
     *
     * @return Mono con el resultado del recorrido BFS.
     */
    @GetMapping("/recorrido/bfs")
    public Mono<String> recorridoBFS() {
        return peliculaRepo.findAll()
                .collectList()
                .map(listaPeliculas -> {
                    Grafo grafo = new Grafo(listaPeliculas);
                    return grafo.recorridoBFS(listaPeliculas.get(0));
                });
    }

    /**
     * Realiza un recorrido DFS en el grafo de películas.
     *
     * @return Mono con el resultado del recorrido DFS.
     */
    @GetMapping("/recorrido/dfs")
    public Mono<String> recorridoDFS() {
        return peliculaRepo.findAll()
                .collectList()
                .map(listaPeliculas -> {
                    Grafo grafo = new Grafo(listaPeliculas);
                    return grafo.recorridoDFS(listaPeliculas.get(0));
                });
    }
}