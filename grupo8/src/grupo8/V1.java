package grupo8;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JOptionPane;


import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class V1 extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField txtId;
    private JTextField txtProd;
    private JTextField txtPrec;
    private JTextField txtStock;
    private JButton btnInsertar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTextArea textArea;
    private ArrayList<Productos> lista;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    V1 frame = new V1(new ArrayList<>());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public V1(ArrayList<Productos> lista) {
        this.lista = lista;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(21, 19, 44, 12);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Producto");
        lblNewLabel_1.setBounds(21, 41, 44, 12);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Precio");
        lblNewLabel_2.setBounds(21, 63, 44, 12);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Stock");
        lblNewLabel_3.setBounds(21, 85, 44, 12);
        contentPane.add(lblNewLabel_3);

        txtId = new JTextField();
        txtId.setBounds(84, 16, 96, 18);
        contentPane.add(txtId);
        txtId.setColumns(10);

        txtProd = new JTextField();
        txtProd.setBounds(84, 38, 96, 18);
        contentPane.add(txtProd);
        txtProd.setColumns(10);

        txtPrec = new JTextField();
        txtPrec.setBounds(84, 60, 96, 18);
        contentPane.add(txtPrec);
        txtPrec.setColumns(10);

        txtStock = new JTextField();
        txtStock.setBounds(84, 82, 96, 18);
        contentPane.add(txtStock);
        txtStock.setColumns(10);

        btnInsertar = new JButton("Insertar");
        btnInsertar.setBounds(208, 15, 84, 20);
        btnInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id        = Integer.parseInt(txtId.getText().trim());
                    String desc   = txtProd.getText().trim();
                    double precio = Double.parseDouble(txtPrec.getText().trim());
                    int stock     = Integer.parseInt(txtStock.getText().trim());

                    Productos p = new Productos(id, stock, precio, desc);
                    lista.add(p);

                    textArea.append("ID: " + id + " | Producto: " + desc +
                                    " | Precio: " + precio + " | Stock: " + stock + "\n");

                    txtId.setText("");
                    txtProd.setText("");
                    txtPrec.setText("");
                    txtStock.setText("");

                } catch (NumberFormatException ex) {
                    textArea.setText("Error: ID, Precio y Stock deben ser numéricos.");
                }
            }
        });
        contentPane.add(btnInsertar);

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        btnModificar.setBounds(208, 37, 84, 20);
        contentPane.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(208, 59, 84, 20);
        contentPane.add(btnEliminar);

        textArea = new JTextArea();
        textArea.setBounds(21, 110, 405, 143);
        contentPane.add(textArea);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEliminar) {
            do_btnEliminar_actionPerformed(e);
        }
        if (e.getSource() == btnModificar) {
            do_btnModificar_actionPerformed(e);
        }
    }

    protected void do_btnModificar_actionPerformed(ActionEvent e) {
	    String idTexto = txtId.getText().trim();
	    String desc    = txtProd.getText().trim();
	    String precio  = txtPrec.getText().trim();
	    String stock   = txtStock.getText().trim();

	    if (idTexto.isEmpty() || desc.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
	        textArea.setText("Error: Todos los campos son obligatorios.");
	        return;
	    }

	    int id = Integer.parseInt(idTexto);
	    boolean modificado = false;

	    for (Productos p : lista) {
	        if (p.getId() == id) {
	            p.setDescripcion(desc);
	            p.setPrecio(Double.parseDouble(precio));
	            p.setStock(Integer.parseInt(stock));
	            modificado = true;
	            break;
	        }
	    }

	    textArea.setText("");
	    if (modificado) {
	        for (Productos p : lista) {
	            textArea.append("ID: " + p.getId() + " | Producto: " + p.getDescripcion() +
	                            " | Precio: " + p.getPrecio() + " | Stock: " + p.getStock() + "\n");
	        }
	    } else {
	        textArea.setText("Error: No se encontró producto con ID " + id);
	    }

	    txtId.setText("");
    }

    protected void do_btnEliminar_actionPerformed(ActionEvent e) {
    	try {
	        int idEliminar = Integer.parseInt(txtId.getText().trim());

	        boolean eliminado = false;
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i).getId() == idEliminar) {
	                lista.remove(i);
	                eliminado = true;
	                break;
	            }
	        }

	        textArea.setText("");
	        for (Productos p : lista) {
	            textArea.append("ID: " + p.getId() + " | Producto: " + p.getDescripcion() +
	                            " | Precio: " + p.getPrecio() + " | Stock: " + p.getStock() + "\n");
	        }

	        txtId.setText("");

	        if (!eliminado) {
	            textArea.setText("No se encontró un producto con el ID: " + idEliminar);
	        }

	    } catch (NumberFormatException ex) {
	        textArea.setText("Error: El ID debe ser numérico.");
	        JOptionPane.showMessageDialog(
	                this,
	                "Error: El ID debe ser numérico.",
	                "Error de Entrada",
	                JOptionPane.ERROR_MESSAGE
		);
	    }
}

}