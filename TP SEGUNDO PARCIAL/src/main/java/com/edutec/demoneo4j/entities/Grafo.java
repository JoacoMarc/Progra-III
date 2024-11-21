package com.edutec.demoneo4j.entities;

import java.util.*;

public class Grafo {

    private Map<Persona, Set<Pelicula>> PeMap;
    private Map<Pelicula, Set<Persona>> PMap;

    public Grafo(List<Pelicula> movies) {
        PMap = new HashMap<>();
        PeMap = new HashMap<>();
        for (Pelicula pel : movies) {
            // Agregar la película al grafo de películas
            PMap.putIfAbsent(pel, new HashSet<>());

            // Agregar actores y directores a la película
            for (Persona actor : pel.obtenerActores()) {
                PMap.get(pel).add(actor); // Conectar actor con la película
                PeMap.putIfAbsent(actor, new HashSet<>());
                PeMap.get(actor).add(pel); // Conectar película con el actor
            }

            for (Persona director : pel.obtenerDirectores()) {
                PMap.get(pel).add(director); // Conectar director con la película
                PeMap.putIfAbsent(director, new HashSet<>());
                PeMap.get(director).add(pel); // Conectar película con el director
            }
        }
    }

    public void agregarArista(Pelicula pel, Persona per) {
        PMap.get(pel).add(per);
        PeMap.get(per).add(pel);
    }

    public String recorridoBFS(Pelicula inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<Pelicula> visitadoPel = new HashSet<>();
        Set<Persona> visitadoPers = new HashSet<>();
        Queue<Object> cola = new LinkedList<>();

        // Agregar la película inicial
        visitadoPel.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Object actual = cola.poll();

            if (actual instanceof Pelicula) {
                Pelicula pel = (Pelicula) actual;

                // Agregar la información de la película
                resultado.append("Pelicula: ").append(pel.getTitulo()).append("\n");

                // Recorrer los actores
                for (Persona actor : pel.obtenerActores()) {
                    if (!visitadoPers.contains(actor)) {
                        visitadoPers.add(actor);
                        resultado.append("Actor: ").append(actor.getNombre())
                                .append("\n");
                        cola.add(actor); // Agregar al recorrido
                    }
                }

                // Recorrer los directores
                for (Persona director : pel.obtenerActores()) {
                    if (!visitadoPers.contains(director)) {
                        visitadoPers.add(director);
                        resultado.append("Director: ").append(director.getNombre())
                                .append("\n");
                        cola.add(director); // Agregar al recorrido
                    }
                }

                // Recorrer las personas conectadas
                for (Persona persona : PMap.get(pel)) {
                    if (!visitadoPers.contains(persona)) {
                        visitadoPers.add(persona);
                        cola.add(persona);
                    }
                }
            } else if (actual instanceof Persona) {
                Persona persona = (Persona) actual;

                // Recorrer las películas asociadas a esta persona
                for (Pelicula movie : PeMap.get(persona)) {
                    if (!visitadoPel.contains(movie)) {
                        visitadoPel.add(movie);
                        cola.add(movie);
                    }
                }
            }
        }

        return resultado.toString();
    }

    public String recorridoDFS(Pelicula inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<Pelicula> visitadoMovies = new HashSet<>();
        Set<Persona> visitadoPeople = new HashSet<>();
        dfsR(inicio, resultado, visitadoMovies, visitadoPeople);
        return resultado.toString();
    }

    private void dfsR(Object nodo, StringBuilder resultado, Set<Pelicula> visitadoMovies, Set<Persona> visitadoPeople) {
        if (nodo instanceof Pelicula) {
            Pelicula movie = (Pelicula) nodo;

            // Evitar procesar películas ya visitadas
            if (visitadoMovies.contains(movie)) return;
            visitadoMovies.add(movie);

            // Agregar información de la película
            resultado.append("Movie: ").append(movie.getTitulo()).append("\n");

            // Recorrer actores
            for (Persona actor : movie.obtenerActores()) {
                if (!visitadoPeople.contains(actor)) {
                    resultado.append("Actor: ").append(actor.getNombre())
                            .append("\n");
                    dfsR(actor, resultado, visitadoMovies, visitadoPeople);
                }
            }

            // Recorrer directores
            for (Persona director : movie.obtenerDirectores()) {
                if (!visitadoPeople.contains(director)) {
                    resultado.append("Director: ").append(director.getNombre())
                            .append("\n");
                    dfsR(director, resultado, visitadoMovies, visitadoPeople);
                }
            }

            // Recorrer conexiones adicionales en el grafo
            for (Persona persona : PMap.get(movie)) {
                if (!visitadoPeople.contains(persona)) {
                    dfsR(persona, resultado, visitadoMovies, visitadoPeople);
                }
            }
        } else if (nodo instanceof Persona) {
            Persona persona = (Persona) nodo;

            // Evitar procesar personas ya visitadas
            if (visitadoPeople.contains(persona)) return;
            visitadoPeople.add(persona);

            // Recorrer películas asociadas a esta persona
            for (Pelicula movie : PeMap.get(persona)) {
                if (!visitadoMovies.contains(movie)) {
                    dfsR(movie, resultado, visitadoMovies, visitadoPeople);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Películas y personas:\n");
        for (Map.Entry<Pelicula, Set<Persona>> entry : PMap.entrySet()) {
            sb.append("Película: ").append(entry.getKey().getTitulo()).append("\n");
            for (Persona person : entry.getValue()) {
                sb.append("  Persona: ").append(person.getNombre()).append("\n");
            }
        }
        return sb.toString();
    }
}