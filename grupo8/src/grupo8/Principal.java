package grupo8;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenuItem mntmNewMenuItem;
    private JMenu mnNewMenu;
    private JMenuItem mntmNewMenuItem_1;
    private JMenu mnNewMenu_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenu mnNewMenu_2;
    private JMenuItem mntmNewMenuItem_3;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private ArrayList<Productos> lista = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        mnNewMenu = new JMenu("Almacen");
        menuBar.add(mnNewMenu);

        mntmNewMenuItem = new JMenuItem("Stock");
        mnNewMenu.add(mntmNewMenuItem);

        mntmNewMenuItem_1 = new JMenuItem("Productos");
        mntmNewMenuItem_1.addActionListener(this);
        mnNewMenu.add(mntmNewMenuItem_1);

        mnNewMenu_1 = new JMenu("Tienda");
        menuBar.add(mnNewMenu_1);

        mntmNewMenuItem_2 = new JMenuItem("Venta");
        mntmNewMenuItem_2.addActionListener(this);
        mnNewMenu_1.add(mntmNewMenuItem_2);

        mnNewMenu_2 = new JMenu("Salida");
        menuBar.add(mnNewMenu_2);

        mntmNewMenuItem_3 = new JMenuItem("Exit");
        mntmNewMenuItem_3.addActionListener(this);
        mnNewMenu_2.add(mntmNewMenuItem_3);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Bienvenidos al Minimarket ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(117, 10, 205, 33);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/imagen/marker.jpg")));
        lblNewLabel_1.setBounds(82, 36, 256, 195);
        contentPane.add(lblNewLabel_1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmNewMenuItem_1) {
            do_mntmNewMenuItem_1_actionPerformed(e);
        }
        if (e.getSource() == mntmNewMenuItem_2) {
            do_mntmNewMenuItem_2_actionPerformed(e);
        }
        if (e.getSource() == mntmNewMenuItem_3) {
            do_mntmNewMenuItem_3_actionPerformed(e);
        }
    }

    protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {
        V1 p = new V1(lista);
        p.setVisible(true);
    }

    protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {
        Venta ventana = new Venta(lista);
        ventana.setVisible(true);
    }

    protected void do_mntmNewMenuItem_3_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}