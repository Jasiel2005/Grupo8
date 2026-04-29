package grupo8;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    
                    frame.setLocationRelativeTo(null); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        setResizable(false);
        setTitle("VendeMás - Pantalla de Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 450); // Ventana más ancha tipo pantalla táctil
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(230, 126, 34)); // Color naranja moderno
        panelIzquierdo.setBounds(0, 0, 300, 411);
        contentPane.add(panelIzquierdo);
        panelIzquierdo.setLayout(null);

        JLabel lblTitulo1 = new JLabel("SISTEMA");
        lblTitulo1.setForeground(new Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo1.setBounds(10, 10, 300, 30);
        panelIzquierdo.add(lblTitulo1);

        JLabel lblTitulo2 = new JLabel("VENDEMÁS");
        lblTitulo2.setForeground(new Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo2.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitulo2.setBounds(10, 44, 300, 50);
        panelIzquierdo.add(lblTitulo2);
        
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/imagen/Sin título.jpg")));
        lblLogo.setForeground(new Color(255, 255, 255));
        lblLogo.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setBounds(10, 10, 280, 380);
        panelIzquierdo.add(lblLogo);

        
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(255, 255, 255));
        panelDerecho.setBounds(300, 0, 384, 411);
        contentPane.add(panelDerecho);
        panelDerecho.setLayout(null);

        JLabel lblBienvenido = new JLabel("INICIO DE SESIÓN");
        lblBienvenido.setForeground(new Color(51, 51, 51));
        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblBienvenido.setBounds(0, 50, 384, 30);
        panelDerecho.add(lblBienvenido);

        // --- BOTÓN 1: ALMACÉN ---
        JButton btnAlmacen = new JButton("📦 Gestión de Almacén");
        btnAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        btnAlmacen.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnAlmacen.setBackground(new Color(41, 128, 185));  
        btnAlmacen.setForeground(Color.BLACK);
        btnAlmacen.setFocusPainted(false);
        btnAlmacen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                V1 ventanaAlmacen = new V1();
                ventanaAlmacen.setLocationRelativeTo(null);
                ventanaAlmacen.setVisible(true);
            }
        });
        btnAlmacen.setBounds(50, 120, 280, 45);
        panelDerecho.add(btnAlmacen);

        
        JButton btnVenta = new JButton("🛒 Punto de Venta (Caja)");
        btnVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVenta.setBackground(new Color(39, 174, 96)); // 
        btnVenta.setForeground(Color.LIGHT_GRAY);
        btnVenta.setFocusPainted(false);
        btnVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // LÓGICA DE CONTRASEÑA
                JPasswordField pwd = new JPasswordField(10);
                int accion = JOptionPane.showConfirmDialog(null, pwd, "Ingrese clave de Cajero:", JOptionPane.OK_CANCEL_OPTION);
                
                if (accion == JOptionPane.OK_OPTION) {
                    String pass = new String(pwd.getPassword());
                    
                    if (pass.equals("1234")) { // LA CONTRASEÑA ES 1234
                        Venta ventanaVentas = new Venta();
                        ventanaVentas.setLocationRelativeTo(null);
                        ventanaVentas.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Contraseña incorrecta.", "Seguridad", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnVenta.setBounds(50, 190, 280, 45);
        panelDerecho.add(btnVenta);

        
        JButton btnSalir = new JButton("❌ Salir del Sistema");
        btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSalir.setBackground(new Color(192, 57, 43)); 
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSalir.setBounds(50, 260, 280, 45);
        panelDerecho.add(btnSalir);
    }
}