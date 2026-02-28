package edu.jose.mejia.proyecto.ui;

import edu.jose.mejia.proyecto.bd.LibrosDisponibles;
import edu.jose.mejia.proyecto.calcular.CalculadorPrecio;
import edu.jose.mejia.proyecto.core.CarritoDeCompras;
import edu.jose.mejia.proyecto.core.SistemaTienda;
import edu.jose.mejia.proyecto.data.Libro;
import edu.jose.mejia.proyecto.data.LibroVista;
import edu.jose.mejia.proyecto.data.Usuario;
import edu.jose.mejia.proyecto.idioma.Idioma;
import edu.jose.mejia.proyecto.idioma.IdiomaEspanol;
import edu.jose.mejia.proyecto.idioma.IdiomaIngles;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class VentanaPrincipal extends JFrame {

    private SistemaTienda sistema;
    private CarritoDeCompras carrito;
    private Usuario usuario;
    private LibrosDisponibles repositorio;

    private DefaultListModel<LibroVista> modeloLibros;
    private DefaultListModel<LibroVista> modeloCarrito;

    private JList<LibroVista> listaLibros;
    private JList<LibroVista> listaCarrito;

    private JTextField campoBusqueda;
    private JTextField campoNombreUsuario;
    private JComboBox<String> comboTipoUsuario;

    private JLabel labelUsuario;
    private JLabel labelDescuento;
    private JLabel labelBuscar;
    private JLabel labelNombre;

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnFinalizar;

    private JPanel panelUsuarioInfo;

    private Idioma idioma;

    private JLabel labelFecha;
    private JTextField campoFecha;

    public VentanaPrincipal() {
        idioma = new IdiomaEspanol();
        sistema = new SistemaTienda();
        carrito = new CarritoDeCompras();
        repositorio = new LibrosDisponibles();

        configurarVentana();
        inicializarComponentes();

        setVisible(true);
    }

    private void configurarVentana() {
        setTitle(idioma.tituloVentana());
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelUsuarioInput = new JPanel(new FlowLayout(FlowLayout.LEFT));

        labelNombre = new JLabel();
        campoNombreUsuario = new JTextField(10);

        comboTipoUsuario = new JComboBox<>();

        JButton btnEstablecerUsuario = new JButton("OK");

        JComboBox<String> comboIdioma =
                new JComboBox<>(new String[]{"Español", "English"});

        panelUsuarioInput.add(labelNombre);
        panelUsuarioInput.add(campoNombreUsuario);
        panelUsuarioInput.add(comboTipoUsuario);
        panelUsuarioInput.add(btnEstablecerUsuario);
        panelUsuarioInput.add(comboIdioma);

        JPanel panelBusqueda = new JPanel(new BorderLayout());

        labelBuscar = new JLabel();
        campoBusqueda = new JTextField();

        panelBusqueda.add(labelBuscar, BorderLayout.WEST);
        panelBusqueda.add(campoBusqueda, BorderLayout.CENTER);

        panelSuperior.add(panelUsuarioInput);
        panelSuperior.add(panelBusqueda);

        add(panelSuperior, BorderLayout.NORTH);

        // ===== PANEL CENTRAL =====

        JPanel panelCentral = new JPanel(new GridLayout(1, 3, 15, 15));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        modeloLibros = new DefaultListModel<>();
        listaLibros = new JList<>(modeloLibros);
        JScrollPane scrollLibros = new JScrollPane(listaLibros);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 20));

        btnAgregar = new JButton();
        btnEliminar = new JButton();
        btnFinalizar = new JButton();

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnFinalizar);

        labelFecha = new JLabel();
        campoFecha = new JTextField(8);

        panelUsuarioInput.add(labelFecha);
        panelUsuarioInput.add(campoFecha);

        modeloCarrito = new DefaultListModel<>();
        listaCarrito = new JList<>(modeloCarrito);
        JScrollPane scrollCarrito = new JScrollPane(listaCarrito);

        panelCentral.add(scrollLibros);
        panelCentral.add(panelBotones);
        panelCentral.add(scrollCarrito);

        add(panelCentral, BorderLayout.CENTER);

        // ===== PANEL USUARIO INFO =====

        panelUsuarioInfo = new JPanel(new GridLayout(2, 1));

        labelUsuario = new JLabel();
        labelDescuento = new JLabel();

        panelUsuarioInfo.add(labelUsuario);
        panelUsuarioInfo.add(labelDescuento);

        add(panelUsuarioInfo, BorderLayout.SOUTH);

        // ===== EVENTOS =====

        btnEstablecerUsuario.addActionListener(e -> establecerUsuario());

        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                filtrarLibros();
            }
        });

        btnAgregar.addActionListener(e -> agregarAlCarrito());
        btnEliminar.addActionListener(e -> eliminarDelCarrito());
        btnFinalizar.addActionListener(e -> finalizarCompra());

        comboIdioma.addActionListener(e -> {
            if (comboIdioma.getSelectedItem().equals("Español")) {
                idioma = new IdiomaEspanol();
            } else {
                idioma = new IdiomaIngles();
            }
            actualizarIdioma();
        });

        actualizarIdioma();
        cargarLibros(repositorio.getLibros());
    }

    private void actualizarIdioma() {

        setTitle(idioma.tituloVentana());

        labelNombre.setText(idioma.nombre());
        labelBuscar.setText(idioma.buscar());
        labelFecha.setText(idioma.fecha());

        btnAgregar.setText(idioma.agregar());
        btnEliminar.setText(idioma.eliminar());
        btnFinalizar.setText(idioma.finalizarCompra());

        panelUsuarioInfo.setBorder(
                BorderFactory.createTitledBorder(idioma.usuario())
        );

        comboTipoUsuario.removeAllItems();
        comboTipoUsuario.addItem(idioma.estudiante());
        comboTipoUsuario.addItem(idioma.maestro());
        comboTipoUsuario.addItem(idioma.cliente());

        actualizarVista();
    }

    private void establecerUsuario() {

        String nombre = campoNombreUsuario.getText().trim();
        String tipo = (String) comboTipoUsuario.getSelectedItem();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingresa un nombre.");
            return;
        }

        if (tipo.equals(idioma.estudiante())) {
            usuario = new Usuario.Estudiante(nombre);
        } else if (tipo.equals(idioma.maestro())) {
            usuario = new Usuario.Maestro(nombre);
        } else {
            usuario = new Usuario.Cliente(nombre);
        }

        labelUsuario.setText(
                idioma.nombre() + " " + usuario.getNombre()
        );

        actualizarIdioma();
    }

    private void cargarLibros(List<Libro> libros) {
        modeloLibros.clear();
        for (Libro l : libros) {
            modeloLibros.addElement(new LibroVista(l, idioma));
        }
    }

    private void filtrarLibros() {
        String texto = campoBusqueda.getText().toLowerCase();

        List<Libro> filtrados = repositorio.getLibros()
                .stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(texto)
                        || l.getAutor().toLowerCase().contains(texto))
                .collect(Collectors.toList());

        cargarLibros(filtrados);
    }

    private void agregarAlCarrito() {

        LibroVista vista = listaLibros.getSelectedValue();
        Libro seleccionado = vista != null ? vista.getLibro() : null;

        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un libro.");
            return;
        }

        carrito.agregarLibro(seleccionado);
        actualizarVista();
    }

    private void eliminarDelCarrito() {

        LibroVista vista = listaCarrito.getSelectedValue();
        Libro seleccionado = vista != null ? vista.getLibro() : null;

        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un libro.");
            return;
        }

        carrito.quitarLibro(seleccionado);
        actualizarVista();
    }

    private void finalizarCompra() {

        if (usuario == null) {
            JOptionPane.showMessageDialog(this,
                    "Establece un usuario.");
            return;
        }

        if (carrito.getLibros().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Carrito vacío.");
            return;
        }

        String fecha = campoFecha.getText().trim();

        if (fecha.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingresa una fecha.");
            return;
        }

        double total = new CalculadorPrecio()
                .calcularTotal(carrito, usuario);

        System.out.println("===== COMPRA REALIZADA =====");
        System.out.println("Cliente: " + usuario.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Libros comprados:");

        for (Libro l : carrito.getLibros()) {
            System.out.println("- " + l.getTitulo() + " | $" + l.getPrecio());
        }

        System.out.println("Total pagado: $" + total);
        System.out.println("============================");

        carrito.vaciarCarrito();
        actualizarVista();

        JOptionPane.showMessageDialog(this,
                "Total: $" + total);
    }

    private void actualizarVista() {

        modeloCarrito.clear();

        for (Libro l : carrito.getLibros()) {
            modeloCarrito.addElement(new LibroVista(l, idioma));
        }

        cargarLibros(repositorio.getLibros());
    }
}