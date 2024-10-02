import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    List<Libro> coleccionLibros;

    public Biblioteca() {
        this.coleccionLibros = new ArrayList<>();
    }

    // Agregar un libro
    public void agregarLibro(Libro libro) {
        if (!coleccionLibros.contains(libro)) {
            coleccionLibros.add(libro);
            System.out.println("Libro agregado: " + libro);
        } else {
            System.out.println("El libro ya existe en la colección.");
        }
    }

    // Eliminar un libro
    public void eliminarLibro(String isbn) {
        Iterator<Libro> it = coleccionLibros.iterator();
        boolean encontrado = false;
        while (it.hasNext()) {
            Libro libro = it.next();
            if (libro.getIsbn().equals(isbn)) {
                it.remove();
                encontrado = true;
                System.out.println("Libro eliminado: " + libro);
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el libro con ISBN: " + isbn);
        }
    }

    // Buscar un libro por ISBN
    public Libro buscarLibro(String isbn) {
        for (Libro libro : coleccionLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Mostrar todos los libros
    public void mostrarLibros() {
        for (Libro libro : coleccionLibros) {
            System.out.println(libro);
        }
    }
}
