/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author Fernando Mendoza
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*-*Bienvenidos a la Biblioteca Virtual de Fernando*-*");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por titulo o autor");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar los libros disponibles");
            System.out.println("6. Agregar comentario a un libro");
            System.out.println("7. Agregar calificacion a un libro");
            System.out.println("8. Mostrar estadisticas de generos");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicacion: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Genero: ");
                    String genero = scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, anio, genero));
                    System.out.println("Libro agregado exitosamente.");
                    break;
                case 2:
                    System.out.print("Introduce el titulo o autor del libro: ");
                    String criterio = scanner.nextLine();
                    System.out.println("Resultados de la busqueda:");
                    for (Libro libro : biblioteca.buscarLibros(criterio)) {
                        System.out.println(libro);
                    }
                    break;
                case 3:
                    System.out.print("Introduce el titulo del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    if (biblioteca.prestarLibro(tituloPrestar)) {
                        System.out.println("El libro ha sido prestado correctamente.");
                    } else {
                        System.out.println("El libro no esta disponible.");
                    }
                    break;
                case 4:
                    System.out.print("Introduce el titulo del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    if (biblioteca.devolverLibro(tituloDevolver)) {
                        System.out.println("Libro devuelto con exito.");
                    } else {
                        System.out.println("El libro no se pudo devolver.");
                    }
                    break;
                case 5:
                    System.out.println("Libros disponibles:");
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 6:
                    System.out.print("Introduce el titulo del libro para agregar un comentario: ");
                    String tituloComentario = scanner.nextLine();
                    System.out.print("Introduce un comentario: ");
                    String comentario = scanner.nextLine();
                    biblioteca.agregarComentario(tituloComentario, comentario);
                    break;
                case 7:
                    System.out.print("Introduce el titulo del libro para agregar una calificacion: ");
                    String tituloCalificacion = scanner.nextLine();
                    System.out.print("Introduce una calificacion (1-5): ");
                    int calificacion = scanner.nextInt();
                    scanner.nextLine(); 
                    biblioteca.agregarCalificacion(tituloCalificacion, calificacion);
                    break;
                case 8:
                    System.out.println("Estadisticas de generos:");
                    biblioteca.mostrarEstadisticasGeneros();
                    break;
                case 9:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Por favor, elige una opcion del 1 al 9.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}      