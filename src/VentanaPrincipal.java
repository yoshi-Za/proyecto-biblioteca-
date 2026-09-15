import javax.swing.*;
import java.awt.*;
import java.time.Year;

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

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(2, 3, 15, 10));
        panelCampos.setPreferredSize(new Dimension(550, 100));


        JPanel panelTitulo = new JPanel(new BorderLayout(5, 3));
        panelTitulo.add(new JLabel("Título"), BorderLayout.NORTH);

        txtTitulo = new JTextField();
        txtTitulo.setPreferredSize(new Dimension(160, 25));
        panelTitulo.add(txtTitulo, BorderLayout.CENTER);

        panelCampos.add(panelTitulo);


        JPanel panelAutor = new JPanel(new BorderLayout(5, 3));
        panelAutor.add(new JLabel("Autor"), BorderLayout.NORTH);

        txtAutor = new JTextField();
        txtAutor.setPreferredSize(new Dimension(160, 25));
        panelAutor.add(txtAutor, BorderLayout.CENTER);

        panelCampos.add(panelAutor);


        JPanel panelCodigo = new JPanel(new BorderLayout(5, 3));
        panelCodigo.add(new JLabel("Código"), BorderLayout.NORTH);

        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension(160, 25));
        panelCodigo.add(txtCodigo, BorderLayout.CENTER);

        panelCampos.add(panelCodigo);


        JPanel panelGenero = new JPanel(new BorderLayout(5, 3));
        panelGenero.add(new JLabel("Género"), BorderLayout.NORTH);

        txtGenero = new JTextField();
        txtGenero.setPreferredSize(new Dimension(160, 25));
        panelGenero.add(txtGenero, BorderLayout.CENTER);

        panelCampos.add(panelGenero);


        JPanel panelAño = new JPanel(new BorderLayout(5, 3));
        panelAño.add(new JLabel("Año de publicación"), BorderLayout.NORTH);

        txtAño = new JTextField();
        txtAño.setPreferredSize(new Dimension(160, 25));
        panelAño.add(txtAño, BorderLayout.CENTER);

        panelCampos.add(panelAño);


        JPanel panelCopias = new JPanel(new BorderLayout(5, 3));
        panelCopias.add(new JLabel("Copias disponibles"), BorderLayout.NORTH);

        txtCopias = new JTextField();
        txtCopias.setPreferredSize(new Dimension(160, 25));
        panelCopias.add(txtCopias, BorderLayout.CENTER);

        panelCampos.add(panelCopias);


        JButton btnCrear = new JButton("Crear libro");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnCrear);


        panel.add(panelCampos, BorderLayout.NORTH);
        panel.add(panelBoton, BorderLayout.CENTER);


        setTitle("Gestión de Libros");
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnCrear.addActionListener(e -> crearLibro());

        add(panel);
    }

    private void crearLibro() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String codigo = txtCodigo.getText();
        String genero = txtGenero.getText();
        String año = txtAño.getText();
        String copias = txtCopias.getText();

        if (titulo.isEmpty() || autor.isEmpty() || codigo.isEmpty() || genero.isEmpty() || año.isEmpty() || copias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos");
        }
        int añoPlublicacion;
        int  copiasPlublicacion;

        try {
            añoPlublicacion=Integer.parseInt(año);
            copiasPlublicacion=Integer.parseInt(copias);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "El año y las copias deben de ser numeros");
            return;
        }
        if (copiasPlublicacion < 0){
            JOptionPane.showMessageDialog(null, "La copia debe ser positivo");
            return;
        }
        int añoActual = Year.now().getValue();

        if (añoPlublicacion > añoActual){
            JOptionPane.showMessageDialog(this,"El año de publicación no puede ser mayor al año actual");
            return;
        }
        if (biblioteca.codigoExistente(codigo)){
            JOptionPane.showMessageDialog(this,"El libro ya existe");
            return;
        }
        Libro libro = new Libro(
                titulo, autor, codigo, genero, añoPlublicacion, copiasPlublicacion
        );

        biblioteca.agregarLibro(libro);

        JOptionPane.showMessageDialog(this,"Libro agregado correctamente");

        txtTitulo.setText("");
        txtAutor.setText("");
        txtCodigo.setText("");
        txtGenero.setText("");
        txtAño.setText("");
        txtCopias.setText("");
    }
}
