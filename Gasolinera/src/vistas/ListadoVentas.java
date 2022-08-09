package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.Principal;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class ListadoVentas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private Principal controlador;
	private JPanel panel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoVentas frame = new ListadoVentas();
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
	public ListadoVentas() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Listado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de ventas:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matr\u00EDcula", "Nombre", "DNI", "Combustible", "Litros", "Total", "Agrario", "Bonificaci\u00F3n gobierno", "Porque tu vuelves"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 2,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				controlador.mostrarAlta(fila);
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Volver");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarAlta();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
	}

	public void setListaRepostajes(List<Repostaje> listaRepostajes) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		// vaciamos la tabla
		modelo.setRowCount(0);
		for (Repostaje repostaje : listaRepostajes) {
			Object [] fila = {
					repostaje.getMatricula(), repostaje.getNombre(),
					repostaje.getDni(), repostaje.getCombustible(),
					repostaje.getLitros(),repostaje.getTotal(),
					repostaje.isAgrario(), repostaje.isGobierno(),
					repostaje.isVuelves()
			};
			modelo.addRow(fila);
		} 
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}

	


}
