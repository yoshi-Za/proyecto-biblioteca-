import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Biblioteca {

    // ArrayList: almacena todos los libros
    private ArrayList<Libro> libros;

    // HashMap: permite organizar libros por autor
    private HashMap<String, ArrayList<Libro>> indiceAutores;

    // HashSet: evita códigos repetidos
    private HashSet<String> codigos;

    public Biblioteca() {
        libros = new ArrayList<>();
        indiceAutores = new HashMap<>();
        codigos = new HashSet<>();

        agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "LIB-001", "Realismo Mágico", 1967, 5));
        agregarLibro(new Libro("Fahrenheit 451", "Ray Bradbury", "LIB-002", "Ciencia Ficción", 1953, 4));
        agregarLibro(new Libro("Orgullo y prejuicio", "Jane Austen", "LIB-003", "Romance", 1813, 6));
        agregarLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien", "LIB-004", "Fantasía", 1954, 3));
        agregarLibro(new Libro("Ensayo sobre la ceguera", "José Saramago", "LIB-005", "Novela", 1995, 2));
        agregarLibro(new Libro("La metamosfosis", "Franz Kafka", "LIB-006", "Absurdo", 1915, 7));
    }

    // agrega un libro
    public void agregarLibro(Libro libro) {

        if (codigos.contains(libro.getCodigo())) {
            throw new IllegalArgumentException(
                    "Ya existe un libro con ese código."
            );
        }

        libros.add(libro);
        codigos.add(libro.getCodigo());

        String autor = libro.getAutor().toLowerCase();

        indiceAutores.putIfAbsent(
                autor,
                new ArrayList<>()
        );

        indiceAutores.get(autor).add(libro);
    }

    // elimina un libro
    public void eliminarLibro(int posicion) {

        Libro libro = libros.remove(posicion);

        codigos.remove(libro.getCodigo());

        String autor = libro.getAutor().toLowerCase();

        ArrayList<Libro> lista = indiceAutores.get(autor);

        if (lista != null) {
            lista.remove(libro);

            if (lista.isEmpty()) {
                indiceAutores.remove(autor);
            }
        }
    }

    // Método con retorno
    public ArrayList<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }

    // Método con retorno para filtrar por autor
    public ArrayList<Libro> filtrarPorAutor(String autor) {

        ArrayList<Libro> resultado = new ArrayList<>();

        String texto = autor.trim().toLowerCase();

        if (texto.isEmpty()) {
            return obtenerTodos();
        }

        for (Libro libro : libros) {

            if (libro.getAutor()
                    .toLowerCase()
                    .contains(texto)) {

                resultado.add(libro);
            }
        }

        return resultado;
    }

    public int cantidadLibros() {
        return libros.size();
    }
}