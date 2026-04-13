package grupo8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPre;
	private JTextField txtStock;
	private JTextField txtBus;

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
		setBounds(100, 100, 692, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRUEBA");
		lblNewLabel.setBounds(10, 10, 44, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRECIO :");
		lblNewLabel_1.setBounds(10, 111, 44, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STOCK :");
		lblNewLabel_2.setBounds(10, 133, 44, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BUSCAR :");
		lblNewLabel_3.setBounds(10, 155, 58, 12);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NOMBRE :");
		lblNewLabel_4.setBounds(10, 79, 58, 12);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SISTEMA DE VENTAS");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(89, 10, 138, 12);
		contentPane.add(lblNewLabel_5);
		
		txtNom = new JTextField();
		txtNom.setBounds(63, 76, 96, 18);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setColumns(10);
		txtPre.setBounds(64, 108, 96, 18);
		contentPane.add(txtPre);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(63, 130, 96, 18);
		contentPane.add(txtStock);
		
		txtBus = new JTextField();
		txtBus.setColumns(10);
		txtBus.setBounds(64, 152, 96, 18);
		contentPane.add(txtBus);
		
		JButton btnAdicionar = new JButton("ADICIONAR PRODUCTO");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(169, 90, 156, 20);
		contentPane.add(btnAdicionar);
		
		JButton btnReportar = new JButton("GENERAR REPORTE");
		btnReportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReportar.setBounds(169, 133, 156, 20);
		contentPane.add(btnReportar);
		
		JButton btnBuscar = new JButton("BUSCAR POR NOMBRE");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(169, 171, 156, 20);
		contentPane.add(btnBuscar);
		
		JTextArea textReporte = new JTextArea();
		textReporte.setBounds(335, 28, 295, 201);
		contentPane.add(textReporte);

	}
}
