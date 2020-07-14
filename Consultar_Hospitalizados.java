import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Consultar_Hospitalizados extends JDialog {
	private JTable table;

	public Consultar_Hospitalizados(ArrayList<Hospitalizado>listaHospitalizados) {
		
		setModal(true);
		
		setBounds(100, 100, 654, 435);
		getContentPane().setLayout(null);

		JLabel lblHospitalizados = new JLabel("HOSPITALIZADO");
		lblHospitalizados.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblHospitalizados.setBounds(226, 21, 149, 51);
		getContentPane().add(lblHospitalizados);

		JButton btnSalir = new JButton("EXIT");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(456, 322, 155, 47);
		getContentPane().add(btnSalir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 83, 568, 229);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Estado del paciente", "Fecha"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(145);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		llenaTabla(listaHospitalizados);
		setVisible(true);
	}


	private void llenaTabla (ArrayList<Hospitalizado>listaHospitalizados) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		for (int i = 0; i <listaHospitalizados.size(); i++) {
			String nombre1 = listaHospitalizados.get(i).getNombre1();
			String enfermedad = listaHospitalizados.get(i).getEnfermedad();
			String tratamiento= listaHospitalizados.get(i).getTratamiento();
			model.addRow(new Object[]{nombre1,enfermedad,tratamiento});
		}
		table.repaint();
	}	
}