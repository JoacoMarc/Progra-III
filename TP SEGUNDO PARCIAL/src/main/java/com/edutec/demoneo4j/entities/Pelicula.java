package com.edutec.demoneo4j.entities;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Pelicula")
public class Pelicula {
    @Id
    private final String titulo;

    @Property("tagline")
    private final String descripcion;

    @Relationship(type = "ACTUARON_EN", direction = INCOMING)
    private Set<Persona> actores = new HashSet<>();

    @Relationship(type = "DIRIGIDO_EN", direction = INCOMING)
    private Set<Persona> directores = new HashSet<>();

    public Pelicula(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Persona> obtenerActores() {
        return actores;
    }

    public void setActores(Set<Persona> actores) {
        this.actores = actores;
    }

    public Set<Persona> obtenerDirectores() {
        return directores;
    }

    public void setDirectores(Set<Persona> directores) {
        this.directores = directores;
    }
}
