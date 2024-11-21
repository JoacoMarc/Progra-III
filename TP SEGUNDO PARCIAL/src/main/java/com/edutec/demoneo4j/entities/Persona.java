package com.edutec.demoneo4j.entities;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Persona")
public class Persona {
    @Id
    private final String nombre;
    private final Integer nacidoEn;
    public Persona(Integer nacidoEn, String nombre) {
        this.nacidoEn = nacidoEn;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNacidoEn() {
        return nacidoEn;
    }
}