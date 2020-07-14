import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Urgencia extends JDialog {
	private JTable table;
	private String nombre;
	private String fecha;
	private int edad;
	private String genero;
	private String sintomas ;
	private String e_e;
	ArrayList <Paciente> copy = new ArrayList();

	public Urgencia ( ArrayList<Paciente> listaPacientes) {
		setModal(true);
		setTitle("Atendido");
		setBounds(100, 100, 724, 332);
		getContentPane().setLayout(null);

		JButton btnMarcarComoEmergencia = new JButton("En emergencia");
		btnMarcarComoEmergencia.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				for (int i=0; i<listaPacientes.size(); i++) {
					nombre=listaPacientes.get(i).getNombre();
					fecha=listaPacientes.get(i).getFecha();
					edad=listaPacientes.get(i).getEdad();
					genero=listaPacientes.get(i).getGenero();
					sintomas =listaPacientes.get(i).getSintomas ();
					e_e=listaPacientes.get(i).getE_e();

					if ((boolean)model.getValueAt(i,0)) {
						String estado = "Emergencia";
						listaPacientes.get(i).setE_e(estado);
						e_e=estado;
					}
				}
				for (int j=0; j<listaPacientes.size(); j++) {
					Paciente temporal;
					temporal=listaPacientes.get(j);
					copy.add(temporal);
				}
				
				guardar();
				setVisible(false);
			}
		});
		btnMarcarComoEmergencia.setBounds(475, 231, 211, 33);
		getContentPane().add(btnMarcarComoEmergencia);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});

		btnSalir.setBounds(308, 231, 129, 33);
		getContentPane().add(btnSalir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 30, 636, 190);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emergencia", "nombre", "edad"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		llenaTabla(listaPacientes);
		setVisible(true);
	}

	private void llenaTabla (ArrayList<Paciente> listaPacientes)
	{
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		for (int i = 0; i <listaPacientes.size(); i++)
		{
			String nombre1=listaPacientes.get(i).getNombre();
			int edad1=listaPacientes.get(i).getEdad();
			model.addRow(new Object[]{false,nombre1,edad1});
		}

		table.repaint();
	}

		/*public static void guardarTodo(String informacion){
            	try
            	{
            		FileOutputStream fos = new FileOutputStream ("Paciente.txt");
            		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            		out.write(informacion);                     
            		out.close();
            	} 
            	catch (Exception e) 
            	//Agregar Excepciones         
            	{
            		e.printStackTrace();
            		System.exit(1);
            	}
            } */
	
	public void guardar(){
		FileWriter fichero = null;
		PrintWriter pw = null;
		BufferedWriter bw=null;
		String texto = null;
		String ruta;
		try
		{

			//ejemplo, ruta donde esta mi archivo
			ruta="C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/registro.txt";
			File file = new File(ruta);
			fichero = new FileWriter(file,true);
			pw = new PrintWriter(fichero);
			bw= new BufferedWriter(pw);
			
			for (int j=0; j<copy.size(); j++) 
			{
				nombre=copy.get(j).getNombre();
				fecha=copy.get(j).getFecha();
				edad=copy.get(j).getEdad();
				genero=copy.get(j).getGenero();
				sintomas =copy.get(j).getSintomas ();
				e_e=copy.get(j).getE_e();
			}
			//			pw.println(""); //escribe la cadena y termina la linea
			bw.append(texto); //agrega texto al archivo y el cursor se queda en la misma linea

			String datosPaciente=(nombre + "@" + fecha + "@" + edad + "@" + genero + "@" + sintomas  + "@" + e_e);
			pw.println(datosPaciente);
			bw.flush();  //envia el texto al archivo

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		 finally 
		{
		
			try {
		
				if (null != fichero) 
					fichero.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
	
} 
