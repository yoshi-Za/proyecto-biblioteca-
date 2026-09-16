import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.Year;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private Biblioteca biblioteca;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtCodigo;
    private JTextField txtGenero;
    private JTextField txtAño;
    private JTextField txtCopias;
    private DefaultTableModel modelTabla;
    private JTable tablaLibros;
    private JTextField txtFiltroAutor;

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

        // --- BÚSQUEDA Y FILTRO ---
        JPanel panelBuscador = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBuscador.add(new JLabel("Filtrar por autor:"));
        txtFiltroAutor = new JTextField(12);
        panelBuscador.add(txtFiltroAutor);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnLimpiar = new JButton("Mostrar Todos");
        JButton btnEliminar = new JButton("Eliminar Seleccionado");

        panelBuscador.add(btnBuscar);
        panelBuscador.add(btnLimpiar);
        panelBuscador.add(btnEliminar);

// --- TABLA DE LIBROS ---
        String[] columnas = {"Título", "Autor", "Código", "Género", "Año", "Copias"};
        modelTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Evita editar celdas directamente
            }
        };
        tablaLibros = new JTable(modelTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaLibros);
        scrollTabla.setPreferredSize(new Dimension(550, 180));

// --- ASIGNAR A PANELES ---
        panel.add(panelBuscador, BorderLayout.CENTER);
        panel.add(scrollTabla, BorderLayout.SOUTH);

// --- TAMAÑO DE VENTANA ---
        setSize(650, 500);

// --- EVENTOS DE LOS BOTONES ---
        btnBuscar.addActionListener(e -> buscarPorAutor());
        btnLimpiar.addActionListener(e -> {
            txtFiltroAutor.setText("");
            actualizarTabla(biblioteca.obtenerTodos());
        });
        btnEliminar.addActionListener(e -> eliminarSeleccionado());

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
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los campos");
            return;
        }

        int añoPublicacion;
        int copiasPlublicacion;

        try {
            añoPublicacion = Integer.parseInt(año);
            copiasPlublicacion = Integer.parseInt(copias);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año y las copias deben de ser numeros");
            return;
        }

        if (copiasPlublicacion < 0) {
            JOptionPane.showMessageDialog(null, "La copia debe ser positivo");
            return;
        }

        int añoActual = Year.now().getValue();

        if (añoPublicacion > añoActual) {
            JOptionPane.showMessageDialog(this, "El año de publicación no puede ser mayor al año actual");
            return;
        }

        Libro libro = new Libro(
                titulo, autor, codigo, genero, añoPublicacion, copiasPlublicacion
        );

        try {
            biblioteca.agregarLibro(libro);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(this, "Libro agregado correctamente");

        txtTitulo.setText("");
        txtAutor.setText("");
        txtCodigo.setText("");
        txtGenero.setText("");
        txtAño.setText("");
        txtCopias.setText("");
        // Refresca la tabla automáticamente con el nuevo libro
        actualizarTabla(biblioteca.obtenerTodos());
    }
    // Llena la JTable con la lista de libros actual
    private void actualizarTabla(ArrayList<Libro> listaLibros) {
        modelTabla.setRowCount(0); // Limpia las filas anteriores

        for (Libro libro : listaLibros) {
            Object[] fila = {
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCodigo(),
                    libro.getGenero(),
                    libro.getañoPublicacion(),
                    libro.getCopiasDisponibles()
            };
            modelTabla.addRow(fila);
        }
    }
    // Filtra la tabla con la lógica de Biblioteca
    private void buscarPorAutor() {
        String textoAutor = txtFiltroAutor.getText();
        ArrayList<Libro> resultado = biblioteca.filtrarPorAutor(textoAutor);
        actualizarTabla(resultado);
    }
    // Elimina el libro seleccionado en la tabla
    private void eliminarSeleccionado() {
        int filaSeleccionada = tablaLibros.getSelectedRow();

        if (filaSeleccionada >= 0) {
            biblioteca.eliminarLibro(filaSeleccionada);
            actualizarTabla(biblioteca.obtenerTodos());
            JOptionPane.showMessageDialog(this, "Libro eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro de la tabla");
        }
    }
}

