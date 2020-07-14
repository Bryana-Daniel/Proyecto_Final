import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class E_Medico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private int x;
	private int y;

	private int i;
	private int u;

	private boolean validar;
	private JTextField textField;
	private Hospitalizado hospitalizado;
	private boolean cierre;
	

	public E_Medico(ArrayList<Paciente>listaPacientes) {
		//setModal(true);
		//
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 349, 168);
		getContentPane().add(scrollPane);

		setTitle("Estado Medico del paciente");
		setBounds(100, 100, 788, 391);
		getContentPane().setLayout(null);

		JButton btnAceptar = new JButton("Hospitalizar");
		btnAceptar.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {

				x=getSelectedRow();
				y=getSelectedRow_1();


				validar();
				if (validar==false) {

					JOptionPane.showMessageDialog(null, "HAS SELECCIONADO LOS MISMOS PACIENTES", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
				if (validar==true) {

					String nombre1 = listaPacientes.get(i).getNombre();
					String enfermedad = listaPacientes.get(i).getNombre();
					String tratamiento= textField.getText();
					hospitalizado = new Hospitalizado (nombre1, enfermedad, tratamiento);
					cierre=true;
					JOptionPane.showMessageDialog(null, "GUARDADO EXITOSO", "HOSPITALIZADO", JOptionPane.WARNING_MESSAGE);
					setVisible(false);
				}


			}
		});
		btnAceptar.setBounds(523, 267, 134, 49);
		getContentPane().add(btnAceptar);


		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(344, 267, 134, 49);
		getContentPane().add(btnCancelar);

		JLabel lblSeleccioneLas = new JLabel("Seleccionar persona");
		lblSeleccioneLas.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSeleccioneLas.setBounds(132, 11, 379, 49);
		getContentPane().add(lblSeleccioneLas);

		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel
			(new Object[][] {
				},
				new String[] {
						"", "NOMBRE", "EDAD", "SINTOMAS"
				}) 
			{
			Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		llenaTabla(listaPacientes);


		//AQUI EMPIEZA LA 2DA TABLA
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(392, 71, 370, 168);
		getContentPane().add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);table_1.setRowSelectionAllowed(false);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"", "NOMBRE", "EDAD", "SINTOMAS"
				}
				) {
			Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(3).setResizable(false);

		scrollPane_1.setColumnHeaderView(table_1);
		scrollPane_1.setViewportView(table_1);

		textField = new JTextField();
		textField.setBounds(34, 281, 266, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblFechaDeRegistro = new JLabel("Fecha que ingreso ");
		lblFechaDeRegistro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblFechaDeRegistro.setBounds(113, 250, 108, 20);
		getContentPane().add(lblFechaDeRegistro);
		llenaTabla_1(listaPacientes);
		setVisible(true);
	}


	private void llenaTabla_1 (ArrayList<Paciente>listaPacientes) {
		DefaultTableModel model=(DefaultTableModel) table_1.getModel();
		for (int i = 0; i <listaPacientes.size(); i++) {
			String nombre=listaPacientes.get(i).getNombre();
			int edad=listaPacientes.get(i).getEdad();
			String sintomas=listaPacientes.get(i).getSintomas();
			model.addRow(new Object[]{false,nombre,edad,sintomas});
		}


		table_1.repaint();

	}

	private void llenaTabla (ArrayList<Paciente>listaPacientes) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		for (int i = 0; i <listaPacientes.size(); i++) {
			String nombre=listaPacientes.get(i).getNombre();
			int edad=listaPacientes.get(i).getEdad();
			String sintomas=listaPacientes.get(i).getSintomas();
			model.addRow(new Object[]{false,nombre,edad,sintomas});
		}

		table.repaint();

	}

	private int getSelectedRow() {

		int x2=-1;

		DefaultTableModel model=(DefaultTableModel) table.getModel();

		for (i = 0; i < model.getRowCount(); i++) {
			if ((boolean)model.getValueAt(i,0))
				return i;
		}

		return x2;
	}

	public int getRow() {

		return x;
	}

	private int getSelectedRow_1() {

		int x2=-1;

		DefaultTableModel model=(DefaultTableModel) table_1.getModel();

		for (u = 0; u < model.getRowCount(); u++) {
			if ((boolean)model.getValueAt(u,0))
				return u;
		}
		return x2;

	}

	public int getRow_1() {

		return y;
	}

	public boolean validar() {
		if (x==y) 
		{
			validar=false;
		}
		else 
		validar=true;
		return validar;
	}

	public Hospitalizado getHospitalizado() {

		return hospitalizado;
	}
	public boolean getCierre() {

		return cierre;
	}
	

}