import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private Biblioteca biblioteca;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtCodigo;
    private JTextField txtGenero;
    private JTextField txtAño;
    private JTextField txtCopias;

    public VentanaPrincipal() {
        biblioteca = new Biblioteca();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,3,10,10));

        panel.add(new JLabel("Titulo:"));
        panel.add(txtTitulo = new JTextField());
        panel.add(txtTitulo);

        panel.add(new JLabel("Autor:"));
        panel.add(txtAutor = new JTextField());
        panel.add(txtAutor);

        panel.add(new JLabel("Codigo:"));
        panel.add(txtCodigo = new JTextField());
        panel.add(txtCodigo);

        panel.add(new JLabel("Genero:"));
        panel.add(txtGenero = new JTextField());
        panel.add(txtGenero);

        panel.add(new JLabel("Año publicación"));
        panel.add(txtAño = new JTextField());
        panel.add(txtAño);

        panel.add(new JLabel("Copias:"));
        panel.add(txtCopias = new JTextField());
        panel.add(txtCopias);

        JButton btnCrear = new JButton("Crear Libro");
        panel.add(btnCrear);
    }
}
