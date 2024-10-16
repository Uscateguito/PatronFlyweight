package com.javeriana.flyweight.implementation;

import java.util.ArrayList;
import java.util.List;

public class Artista {

    private String nombre;
    private List<Cancion> canciones = new ArrayList<>();

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public void addCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void removeCancion(Cancion cancion) {
        canciones.remove(cancion);
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void imprimirCanciones() {
        String out = "\nArtista > " + nombre;
        for (Cancion cancion : canciones) {
            out += "\n\t" + cancion.toString();
        }
        System.out.println(out);
    }
    
}
