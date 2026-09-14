public class CrearLibros {

    private String titulo;
    private String autor;
    private String codigo;
    private String genero;
    private int añoPublicacion;
    private int copiasDisponibles;

    public CrearLibros(String titulo, String autor, String codigo, String genero, int añoPublicacion, int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
        this.copiasDisponibles = copiasDisponibles;
    }
}
