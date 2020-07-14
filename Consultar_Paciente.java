import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Consultar_Paciente extends JDialog {
	private JTable table;

	
	public Consultar_Paciente(ArrayList<Paciente>listaPacientes) {
		
		setModal(true);
		setBounds(100, 100, 631, 421);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(454, 296, 127, 50);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 63, 538, 224);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOMBRE", "FECHA", "EDAD", "GENERO", "SINTOMAS","Enfermo/Accidente"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		llenaTabla(listaPacientes);
		
		JLabel lblRegistroDePacientes = new JLabel("Registro de pacientes");
		lblRegistroDePacientes.setBounds(110, 19, 428, 33);
		lblRegistroDePacientes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		getContentPane().add(lblRegistroDePacientes);
		setVisible(true);

	}
	private void llenaTabla (ArrayList<Paciente>listaPacientes) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		for (int i = 0; i <listaPacientes.size(); i++) {
			String nombre = listaPacientes.get(i).getNombre();
			String fecha = listaPacientes.get(i).getFecha();
			int edad = listaPacientes.get(i).getEdad();
			String genero = listaPacientes.get(i).getGenero();
			String sintomas = listaPacientes.get(i).getSintomas();
			String e_e = listaPacientes.get(i).getE_e();
			model.addRow(new Object[]{nombre,fecha,edad,genero,sintomas,e_e});
		}
		table.repaint();

	}
}