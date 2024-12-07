package Cliente;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSeparator;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class IntCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCliente frame = new IntCliente();
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
	public IntCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelAliado = new JPanel();
		contentPane.add(panelAliado);
		panelAliado.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mapa aliado");
		lblNewLabel.setBounds(5, 5, 464, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelAliado.add(lblNewLabel);
		
		JPanel panelMapa = new JPanel();
		panelMapa.setBounds(5, 30, 464, 415);
		panelAliado.add(panelMapa);
		panelMapa.setLayout(new GridLayout(0, 11, 0, 0));
		
		crearMapa(panelMapa);
		
		JPanel panelBarcos = new JPanel();
		panelBarcos.setBounds(480, 5, 140, 440);
		panelAliado.add(panelBarcos);
		panelBarcos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("Barcos");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_11);
		
		JLabel lblNewLabel_1 = new JLabel("■■■■");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("■■■");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("■■■");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("■■");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("■■");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("■■");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("■");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("■");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("■");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("■");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos.add(lblNewLabel_10);
		
		
		JPanel panelEnemigo = new JPanel();
		panelEnemigo.setLayout(null);
		contentPane.add(panelEnemigo);
		
		JLabel lblNewLabel_12 = new JLabel("Mapa enemigo");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(5, 5, 464, 25);
		panelEnemigo.add(lblNewLabel_12);
		
		JPanel panelMapa_1 = new JPanel();
		panelMapa_1.setBounds(5, 30, 464, 415);
		panelEnemigo.add(panelMapa_1);
		panelMapa_1.setLayout(new GridLayout(0, 11, 0, 0));
		
		crearMapa(panelMapa_1);
		
		JPanel panelBarcos_1 = new JPanel();
		panelBarcos_1.setBounds(480, 5, 140, 440);
		panelEnemigo.add(panelBarcos_1);
		panelBarcos_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_11_1 = new JLabel("Barcos");
		lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBarcos_1.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("■■■■");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("■■■");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("■■■");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("■■");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("■■");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("■■");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("■");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("■");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("■");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("■");
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBarcos_1.add(lblNewLabel_10_1);
		
	}
	public void crearMapa(JPanel panelMapa) {
		panelMapa.add(new JLabel(""));
		for(int i=0;i<10;i++) {
			panelMapa.add(new JLabel(""+(char)(i+65),JLabel.CENTER));
		}
		for(int j=1;j<11;j++) {
			panelMapa.add(new JLabel(""+j,JLabel.CENTER));
			for(int i=0;i<10;i++) {
				panelMapa.add(new JButton("o"));
			}
		}
	}
}
