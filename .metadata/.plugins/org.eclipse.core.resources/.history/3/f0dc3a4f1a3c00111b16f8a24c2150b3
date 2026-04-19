package grupo8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextArea txtRes;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(20, 10, 44, 12);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Producto");
			lblNewLabel_1.setBounds(20, 32, 44, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Precio");
			lblNewLabel_2.setBounds(20, 54, 44, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Stock");
			lblNewLabel_3.setBounds(20, 76, 44, 12);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtId = new JTextField();
			txtId.setBounds(83, 7, 96, 18);
			contentPane.add(txtId);
			txtId.setColumns(10);
		}
		{
			txtProd = new JTextField();
			txtProd.setBounds(83, 29, 96, 18);
			contentPane.add(txtProd);
			txtProd.setColumns(10);
		}
		{
			txtPrec = new JTextField();
			txtPrec.setBounds(83, 51, 96, 18);
			contentPane.add(txtPrec);
			txtPrec.setColumns(10);
		}
		{
			txtStock = new JTextField();
			txtStock.setBounds(83, 73, 96, 18);
			contentPane.add(txtStock);
			txtStock.setColumns(10);
		}
		{
			btnInsertar = new JButton("Insertar");
			btnInsertar.setBounds(207, 6, 84, 20);
			contentPane.add(btnInsertar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(207, 28, 84, 20);
			contentPane.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(207, 50, 84, 20);
			contentPane.add(btnEliminar);
		}
		{
			txtRes = new JTextArea();
			txtRes.setBounds(21, 110, 405, 143);
			contentPane.add(txtRes);
		}
		{
			lblNewLabel_4 = new JLabel("eclipse");
			lblNewLabel_4.setBounds(197, 79, 44, 12);
			contentPane.add(lblNewLabel_4);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		
	}
}
