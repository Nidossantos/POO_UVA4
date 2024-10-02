import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Gestión de Biblioteca:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Ordenar por título");
            System.out.println("6. Ordenar por año de publicación");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, anio, isbn));
                    break;

                case 2:
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    biblioteca.eliminarLibro(isbnEliminar);
                    break;

                case 3:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibro(isbnBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("No se encontró el libro.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de libros en la biblioteca:");
                    biblioteca.mostrarLibros();
                    break;

                case 5:
                    Collections.sort(biblioteca.coleccionLibros, new ComparadorTitulo());
                    System.out.println("Libros ordenados por título:");
                    biblioteca.mostrarLibros();
                    break;

                case 6:
                    Collections.sort(biblioteca.coleccionLibros, new ComparadorAnio());
                    System.out.println("Libros ordenados por año de publicación:");
                    biblioteca.mostrarLibros();
                    break;

                case 7:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
