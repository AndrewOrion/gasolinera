package vistas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controladores.Principal;
import modelo.Combustible;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class FormularioAlta extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtLitros;
	private JTextField txtTotal;
	private List<Combustible> listaCombustibles;
	private JComboBox<Combustible>  comboCombustible;
	private JCheckBox cbxAgrario;
	private JCheckBox cbxGobierno;
	private JCheckBox cbxVuelves;
	private Principal controlador;
	private JPanel panel;
	private JButton btnNewButton_1;
	private Repostaje editar=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta frame = new FormularioAlta();
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
	public FormularioAlta() {
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("Nuevo Repostaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Matrícula:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		txtMatricula = new JTextField();
		txtMatricula.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtMatricula, "cell 1 0,grow");
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtNombre, "cell 1 1,grow");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		txtDni = new JTextField();
		txtDni.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtDni, "cell 1 2,grow");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Combustible:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		comboCombustible = new JComboBox<Combustible>();
		comboCombustible.setMaximumSize(new Dimension(32767, 35));
		contentPane.add(comboCombustible, "cell 1 3,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Litros:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		txtLitros = new JTextField();
		txtLitros.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtLitros, "cell 1 4,grow");
		txtLitros.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Total:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		
		txtTotal = new JTextField();
		txtTotal.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtTotal, "cell 1 5,grow");
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Descuento:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_6, "cell 0 6");
		
		cbxAgrario = new JCheckBox("Agrario");
		cbxAgrario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaOtros();
			}
		});
		cbxAgrario.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(cbxAgrario, "flowx,cell 1 6");
		
		cbxGobierno = new JCheckBox("Bonificación Gobierno");
		cbxGobierno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaAgrario();
			}
		});
		cbxGobierno.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(cbxGobierno, "cell 1 6");
		
		cbxVuelves = new JCheckBox("Porque tu vuelves");
		cbxVuelves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compruebaAgrario();
			}
		});
		cbxVuelves.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(cbxVuelves, "cell 1 7");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 8 2 1,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Aceptar");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		btnNewButton_1 = new JButton("Mostrar listado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarListado();
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnNewButton_1);
	}

	protected void compruebaOtros() {
		if(cbxAgrario.isSelected() && 
		  (cbxGobierno.isSelected() || cbxVuelves.isSelected()) ) {
					
			JOptionPane.showMessageDialog(this, 
					"No se pueden seleccionar otros descuentos "
					+ "con el descuento agrario", 
					"Descuento no aplicable", 
					JOptionPane.INFORMATION_MESSAGE);
			cbxAgrario.setSelected(false);
		}
	}

	protected void compruebaAgrario() {
		if (cbxGobierno.isSelected() && cbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, 
				"No se pueden seleccionar el descuento del gobierno "
				+ "con el descuento agrario", 
				"Descuento no aplicable", 
				JOptionPane.INFORMATION_MESSAGE);
			cbxGobierno.setSelected(false);
		}
		if (cbxVuelves.isSelected() && cbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, 
				"No se pueden seleccionar el descuento porque tu "
				+ "vuelves con el descuento agrario", 
				"Descuento no aplicable", 
				JOptionPane.INFORMATION_MESSAGE);
			cbxVuelves.setSelected(false);
		}
		
	}
	
	

	protected void insertar() {
		Repostaje r = new Repostaje();
		if (txtMatricula.getText()==null || txtMatricula.getText().isBlank() ||
			txtNombre.getText()==null || txtNombre.getText().isBlank() ||
			txtDni.getText()==null || txtDni.getText().isBlank() ) {
			
			JOptionPane.showMessageDialog(this, 
					"Los campos matricula, nombre y DNI son obligatorios", 
					"Campos obligatorio vacío", 
					JOptionPane.INFORMATION_MESSAGE);
		    return; 
		}

		r.setMatricula(txtMatricula.getText());
		r.setNombre(txtNombre.getText());
		r.setDni(txtDni.getText());

		if (txtLitros.getText()!=null && !txtLitros.getText().isBlank() &&
		    txtTotal.getText()!=null && !txtTotal.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, 
					"Sólo debe rellenar unos de los dos campos, litros o total", 
					"Dato incorrecto", 
					JOptionPane.INFORMATION_MESSAGE);
			return;
		} 
		
		r.setCombustible((Combustible) comboCombustible.getSelectedItem());
		r.setAgrario(cbxAgrario.isSelected());
		r.setGobierno(cbxGobierno.isSelected());
		r.setVuelves(cbxVuelves.isSelected());
		try {
			if (txtLitros.getText()!=null && !txtLitros.getText().isBlank()) {
				r.setLitros(Double.parseDouble(txtLitros.getText()));
			} else {
				r.setTotal(Double.parseDouble(txtTotal.getText()));
			}			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, 
					"Debe introducir un número válido en litros o total", 
					"Número incorrecto", 
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (editar != null) {
			controlador.borrarRepostaje(editar);
		}
		controlador.insertarRepostaje(r);

	}

	public void setListaCombustibles(List<Combustible> listaCombustibles) {
		this.listaCombustibles = listaCombustibles;
		
		DefaultComboBoxModel<Combustible> modelo = 
				new DefaultComboBoxModel<>();
		
		modelo.addAll(listaCombustibles);
		comboCombustible.setModel(modelo);
		comboCombustible.setSelectedIndex(0);
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}

	public void limpiarFormulario() {
		this.editar=null;
		this.txtMatricula.setText("");
		this.txtNombre.setText("");
		this.txtDni.setText("");
		this.comboCombustible.setSelectedIndex(0);
		this.txtLitros.setText("");
		this.txtTotal.setText("");
		this.cbxAgrario.setSelected(false);
		this.cbxGobierno.setSelected(false);
		this.cbxVuelves.setSelected(false);
	}

	public void setRepostaje(Repostaje r) {
		this.editar = r;
		this.txtMatricula.setText(r.getMatricula());
		this.txtNombre.setText(r.getNombre());
		this.txtDni.setText(r.getDni());
		this.comboCombustible.setSelectedItem(r.getCombustible());
		this.txtLitros.setText(""+r.getLitros());
		this.txtTotal.setText(""+r.getTotal());
		this.cbxAgrario.setSelected(r.isAgrario());
		this.cbxGobierno.setSelected(r.isGobierno());
		this.cbxVuelves.setSelected(r.isVuelves());
	}
	
}
