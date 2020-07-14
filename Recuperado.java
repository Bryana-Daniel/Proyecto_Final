import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Recuperado extends JDialog {
	private JTable table;
	private String nombre1;
	private String enfermedad;
	private String tratamiento;


	public Recuperado(ArrayList <Hospitalizado> hospitalizados) {
		setModal(true);
		setTitle("Tratamiento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 11, 374, 204);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Dar de alto ", "Nombre","Tratamiento"
				}
				) 
		{
			Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnCurar = new JButton("De alta");
		btnCurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				for (int i=0; i<hospitalizados.size(); i++) {
					if ((boolean)model.getValueAt(i,0)) {
						hospitalizados.get(i).setNombre1("Vacio");
						hospitalizados.get(i).setEnfermedad("Vacio");
						hospitalizados.get(i).setTratamiento("Vacio");
					}
				}
				guardar();
				setVisible(false);
			}
		});
		btnCurar.setBounds(335, 226, 89, 23);
		getContentPane().add(btnCurar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(236, 226, 89, 23);
		getContentPane().add(btnCancelar);
		llenaTabla(hospitalizados);
		setVisible(true);
	}
	private void llenaTabla (ArrayList<Hospitalizado>listaHospitalizados) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		for (int i = 0; i <listaHospitalizados.size(); i++) {
			nombre1=listaHospitalizados.get(i).getNombre1();
			enfermedad=listaHospitalizados.get(i).getEnfermedad();
			tratamiento=listaHospitalizados.get(i).getTratamiento();
			model.addRow(new Object[]{false,nombre1,enfermedad});
		}

		table.repaint();

	}

	public void guardar(){
		FileWriter fichero = null;
		PrintWriter pw = null;
		BufferedWriter bw=null;
		String texto = null;
		String ruta;
		try {//ejemplo, ruta donde esta mi archivo
			ruta="C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/hospitalizados.txt";

			fichero = new FileWriter(ruta,false);
			pw = new PrintWriter(fichero);
			bw= new BufferedWriter(pw);

			String datosPaciente = ("-" + "@" + "-" + "@" + "-");
			pw.println(datosPaciente);

			bw.append(texto);

			bw.flush();  //envia el texto al archivo

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//el finally se ejecuta independientemente de si hay error o no
			try {
				// aprovechamos el finally para 
				// asegurarnos que se cierra el fichero.
				if (null != fichero) //se creo el archivo arriba?
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


}