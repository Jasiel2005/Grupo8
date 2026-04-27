package grupo8;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Venta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtID;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtDescuento;
    private JTextArea txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Venta frame = new Venta(new ArrayList<>());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Venta(ArrayList<Productos> lista) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(10, 26, 44, 12);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Precio");
        lblNewLabel_1.setBounds(10, 65, 44, 12);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Cantidad");
        lblNewLabel_2.setBounds(10, 111, 55, 20);
        contentPane.add(lblNewLabel_2);

        txtID = new JTextField();
        txtID.setBounds(75, 23, 96, 18);
        contentPane.add(txtID);
        txtID.setColumns(10);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(75, 62, 96, 18);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(75, 112, 96, 18);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Descuento%");
        lblNewLabel_3.setBounds(226, 26, 70, 12);
        contentPane.add(lblNewLabel_3);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(303, 23, 96, 18);
        contentPane.add(txtDescuento);
        txtDescuento.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idBuscar = Integer.parseInt(txtID.getText().trim());
                    boolean encontrado = false;
                    for (Productos p : lista) {
                        if (p.getId() == idBuscar) {
                            txtResultado.setText("Producto: " + p.getDescripcion() +
                                    "\nPrecio: " + p.getPrecio() +
                                    "\nStock: " + p.getStock());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        txtResultado.setText("No encontrado");
                    }
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Error: ID incorrecto");
                }
            }
        });
        btnNewButton.setBounds(59, 141, 84, 20);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Calcular");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idBuscar = Integer.parseInt(txtID.getText().trim());
                    int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                    double descuento = Double.parseDouble(txtDescuento.getText().trim());
                    double igv = 18.0;

                    Productos encontrado = null;
                    for (Productos p : lista) {
                        if (p.getId() == idBuscar) {
                            encontrado = p;
                            break;
                        }
                    }
                    

                    if (encontrado == null) {
                        txtResultado.setText("No encontrado");
                        return;
                    }

                    if (cantidad > encontrado.getStock()) {
                        txtResultado.setText("Stock insuficiente: " + encontrado.getStock());
                        return;
                    }

                    encontrado.setStock(encontrado.getStock() - cantidad);

                    double subtotal = encontrado.getPrecio() * cantidad;
                    double conDesc  = subtotal - (subtotal * descuento / 100);
                    double conIgv   = conDesc + (conDesc * igv / 100);

                    txtResultado.setText("Subtotal: S/ " + subtotal +
                            "\nCon descuento: S/ " + conDesc +
                            "\nCon IGV 18%: S/ " + conIgv);

                } catch (NumberFormatException ex) {
                    txtResultado.setText("Error: datos incorrectos");
                }
            }
        });
        btnNewButton_1.setBounds(207, 141, 84, 20);
        contentPane.add(btnNewButton_1);

        txtResultado = new JTextArea();
        txtResultado.setBounds(35, 171, 370, 82);
        contentPane.add(txtResultado);
    }
}