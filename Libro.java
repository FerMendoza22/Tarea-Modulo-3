/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Fernando Mendoza
 */
import java.util.ArrayList; 
import java.util.List; 


public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponibilidad;
    private List<String> comentarios; 
    private List<Integer> calificaciones; 
    
    public Libro(String titulo, String autor, int anioPublicacion,
    String genero){ 
        this.titulo = titulo; 
        this.autor = autor; 
        this.anioPublicacion = anioPublicacion; 
        this.genero = genero; 
        this.disponibilidad = true; 
        this.comentarios = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
         
    }
    
    public String getTitulo(){
        return titulo; 
    }
    public String getAutor(){
        return autor; 
    }
    public int getAnioPublicacion(){
        return anioPublicacion;
    }
    public String getGenero(){
        return genero;
    }
    public boolean isDisponible(){
        return disponibilidad; 
    }
    public void prestar(){
        this.disponibilidad = false; 
    }
    public void devolver(){
        this.disponibilidad = true; 
    }
    public void agregarComentario(String comentario)
    {
      comentarios.add(comentario);
    }
    public void agregarCalificacion(int calificacion)
    {
        calificaciones.add(calificacion);
    }
    public double obtenerPromedioCalificaciones(){
        int suma = 0;
        for (int calificacion : calificaciones){
        suma += calificacion; 
    }
    return calificaciones.size() > 0 ? (double)suma / calificaciones.size(): 0;
    }
    
    @Override
    public String toString(){
        return "Titulo: " + titulo + ", Autor: " + autor + ", Año: " + 
        anioPublicacion + ", Genero: " + genero + ", Disponible: " + (disponibilidad ?
        "Si" : "No") + ", Promedio de Calificaciones: " + obtenerPromedioCalificaciones();    
    }
    
    
}
