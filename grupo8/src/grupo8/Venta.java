package grupo8;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Venta extends JFrame {

    private JPanel contentPane;
    private JTextField txtIdVenta;
    private JTextField txtNombreVenta;
    private JTextField txtPrecioVenta;
    private JTextField txtCantidadVenta;
    private JTextField txtDescuento;
    private JTextArea textAreaVenta;

    public Venta() {
        setTitle("Punto de Venta - VendeMás");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pantalla completa
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 242, 245)); // Gris claro de fondo
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- HEADER GRIS OSCURO ---
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 58, 64)); 
        headerPanel.setBounds(0, 0, 2000, 70);
        contentPane.add(headerPanel);
        headerPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("PUNTO DE VENTA (CAJA)");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(40, 15, 400, 40);
        headerPanel.add(lblTitulo);

        // --- PANEL IZQUIERDO (BÚSQUEDA Y VENTA) ---
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
        formPanel.setBounds(50, 110, 450, 500);
        contentPane.add(formPanel);
        formPanel.setLayout(null);

        JLabel lblBuscar = new JLabel("Escanear / Buscar Producto");
        lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblBuscar.setBounds(30, 20, 300, 30);
        formPanel.add(lblBuscar);

        JLabel lblId = new JLabel("ID Producto:");
        lblId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblId.setBounds(30, 80, 100, 25);
        formPanel.add(lblId);

        txtIdVenta = new JTextField();
        txtIdVenta.setBounds(130, 80, 150, 30);
        formPanel.add(txtIdVenta);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(108, 117, 125)); // Gris medio
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idBusca = Integer.parseInt(txtIdVenta.getText());
                    Productos p = AlmacenService.buscarPorId(idBusca);
                    if (p != null) {
                        txtNombreVenta.setText(p.getNombre()); txtPrecioVenta.setText(String.valueOf(p.getPrecio()));
                        textAreaVenta.setText("✅ Producto listo. Stock disponible: " + p.getStock());
                    } else {
                        textAreaVenta.setText("❌ Producto no encontrado."); txtNombreVenta.setText(""); txtPrecioVenta.setText("");
                    }
                } catch (Exception ex) { textAreaVenta.setText("❌ Error: ID inválido."); }
            }
        });
        btnBuscar.setBounds(290, 80, 120, 30);
        formPanel.add(btnBuscar);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNombre.setBounds(30, 130, 100, 25);
        formPanel.add(lblNombre);

        txtNombreVenta = new JTextField();
        txtNombreVenta.setEditable(false);
        txtNombreVenta.setBounds(130, 130, 280, 30);
        formPanel.add(txtNombreVenta);

        JLabel lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPrecio.setBounds(30, 180, 100, 25);
        formPanel.add(lblPrecio);

        txtPrecioVenta = new JTextField();
        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setBounds(130, 180, 150, 30);
        formPanel.add(txtPrecioVenta);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCantidad.setBounds(30, 250, 100, 25);
        formPanel.add(lblCantidad);

        txtCantidadVenta = new JTextField();
        txtCantidadVenta.setBounds(130, 250, 150, 30);
        formPanel.add(txtCantidadVenta);

        JLabel lblDesc = new JLabel("Desc (%):");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDesc.setBounds(30, 300, 100, 25);
        formPanel.add(lblDesc);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(130, 300, 150, 30);
        formPanel.add(txtDescuento);

        JButton btnCalcular = new JButton("💳 COBRAR Y EMITIR BOLETA");
        btnCalcular.setBackground(new Color(0, 123, 255)); // Azul profesional (Checkout)
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idVendido = Integer.parseInt(txtIdVenta.getText());
                    int cant = Integer.parseInt(txtCantidadVenta.getText());
                    double precio = Double.parseDouble(txtPrecioVenta.getText());
                    Productos p = AlmacenService.buscarPorId(idVendido);

                    if (p != null && p.getStock() >= cant) {
                        p.setStock(p.getStock() - cant); // Resta stock
                        double subtotalBase = VentaService.calcularTotal(precio, cant);
                        double conDescuento = subtotalBase; double descuentoAhorrado = 0.0;
                        if (!txtDescuento.getText().isEmpty()) {
                            conDescuento = VentaService.aplicarDescuento(subtotalBase, Double.parseDouble(txtDescuento.getText()));
                            descuentoAhorrado = subtotalBase - conDescuento;
                        }
                        double igv = conDescuento * 0.18; double totalFinal = conDescuento + igv;
                        
                        textAreaVenta.setText(
                            "==================================================\n" +
                            "                 BOLETA ELECTRÓNICA               \n" +
                            "==================================================\n" +
                            " Producto:      " + p.getNombre() + "\n" +
                            " Cantidad:      " + cant + " unds.\n" +
                            "--------------------------------------------------\n" +
                            " Subtotal:      S/ " + String.format("%.2f", subtotalBase) + "\n" +
                            " Descuento:    -S/ " + String.format("%.2f", descuentoAhorrado) + "\n" +
                            " Op. Gravadas:  S/ " + String.format("%.2f", conDescuento) + "\n" +
                            " IGV (18%):    +S/ " + String.format("%.2f", igv) + "\n" +
                            "==================================================\n" +
                            " TOTAL A PAGAR: S/ " + String.format("%.2f", totalFinal) + "\n" +
                            "==================================================\n" +
                            " 📦 Stock restante en almacén: " + p.getStock()
                        );
                        txtIdVenta.setText(""); txtNombreVenta.setText(""); txtPrecioVenta.setText(""); txtCantidadVenta.setText(""); txtDescuento.setText("");
                    } else { textAreaVenta.setText("❌ ERROR: Stock insuficiente."); }
                } catch (Exception ex) { textAreaVenta.setText("❌ ERROR: Ingrese datos válidos."); }
            }
        });
        btnCalcular.setBounds(30, 380, 380, 50);
        formPanel.add(btnCalcular);

        // --- PANEL DERECHO (BOLETA TIPO TICKET) ---
        textAreaVenta = new JTextArea();
        textAreaVenta.setEditable(false);
        textAreaVenta.setFont(new Font("Consolas", Font.BOLD, 16));
        textAreaVenta.setBounds(550, 110, 500, 500);
        contentPane.add(textAreaVenta);
    }
}