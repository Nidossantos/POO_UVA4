import java.util.Objects;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String isbn;

    public Libro(String titulo, String autor, int anioPublicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
               "titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' +
               ", anioPublicacion=" + anioPublicacion +
               ", isbn='" + isbn + '\'' +
               '}';
    }

    @Override
    public int compareTo(Libro otro) {
        return this.isbn.compareTo(otro.getIsbn());  // Comparación por defecto por ISBN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
