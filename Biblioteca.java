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
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class Biblioteca {
    private List<Libro> libros; 
    
    public Biblioteca(){
        this.libros = new ArrayList<> (); 
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro); 
    }
    
    public List<Libro>  buscarLibros(String criterio){
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(criterio) || libro.getAutor().equalsIgnoreCase(criterio)){
               resultados.add(libro); 
            }
        }
        return resultados;
    }
    
    public boolean prestarLibro(String titulo){
        for (Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible()){
               libro.prestar();
               return true; 
            }
       }
            return false; 
    }
    
    public boolean devolverLibro(String titulo){
        for (Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isDisponible()){
               libro.devolver();
               return true; 
            }
        }
            return false; 
    }
    public void mostrarLibrosDisponibles(){
        for (Libro libro : libros){
            if (libro.isDisponible()){
                System.out.println(libro);
            }
        }
    }
    
    public void agregarComentario(String titulo, String comentario){
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)){
                libro.agregarComentario(comentario); 
                System.out.println("Comentario agregado al libro: " + titulo);
                return;
            }
        }
        System.out.println("Libro no encontrado. ");
    }
    
    public void agregarCalificacion(String titulo, int calificacion){
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)){
                libro.agregarCalificacion(calificacion);
                System.out.println("Calificacion agregada al libro: " + titulo);
                return; 
            }
        }
        System.out.println("Libro no encontrado.");
    }
    
    public void mostrarEstadisticasGeneros(){
        Map<String, Integer> conteoGeneros = new HashMap<>();
        for (Libro libro : libros){
            conteoGeneros.put(libro.getGenero(),
            conteoGeneros.getOrDefault(libro.getGenero(), 0) + 1); 
        }
        for (Map.Entry<String, Integer> entry : conteoGeneros.entrySet()){ 
        System.out.println("Genero: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }                  
}
    
        
    

   
    

