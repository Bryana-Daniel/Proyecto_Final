import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Main_Gral extends JDialog {
	ArrayList<Paciente>listaPacientes;
	ArrayList<Hospitalizado>listaHospitalizados;

	ArrayList<String>leerTodo;

	Registrar1 registrar;
	E_Medico em;
	Urgencia emergencia;
	Recuperado recuperado;


	public Main_Gral () {
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);



		leerTodo=new ArrayList<String>();
		listaPacientes=new ArrayList<Paciente>();
		listaHospitalizados=new ArrayList<Hospitalizado>();
		//leer();
		//leer2();
		setBounds(100, 100, 558, 367);
		getContentPane().setLayout(null);

		ImageIcon imagen;
		Icon icono;


		JLabel lblNewLabel = new JLabel("New label");

		lblNewLabel.setBounds(204, 116, 146, 162);
		imagen = new ImageIcon("bry.png");
		icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		getContentPane().add(lblNewLabel);

		JLabel lblBienvenidosARegistro = new JLabel("BIENVENIDOS AL REGISTRO DEL HOSPITAL GENERAL");
		lblBienvenidosARegistro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBienvenidosARegistro.setBounds(61, 11, 436, 129);
		getContentPane().add(lblBienvenidosARegistro);

		JButton btnSalir = new JButton("Exit");
		btnSalir.addActionListener(new ActionListener() {


		public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(412, 231, 100, 50);
		getContentPane().add(btnSalir);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRegistrar1= new JMenu("Registrar");
		menuBar.add(mnRegistrar1);

		JMenuItem mntmNacimiento = new JMenuItem("Paciente");
		mntmNacimiento.addActionListener(new ActionListener() {


		public void actionPerformed(ActionEvent e) {
			registrar = new Registrar1();
			if (registrar.getCierre()==true) 
			{
				Paciente p = registrar.getPaciente();
				listaPacientes.add(p);
				//Archivo.crearArchivo(p.datosPaciente,"registro");
			}

		}
		});
		mnRegistrar1.add(mntmNacimiento);

		JMenuItem mntmInforme = new JMenuItem("Estado Medico"); 
		mntmInforme.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				E_Medico em = new E_Medico(listaPacientes);
				if(em.getCierre()==true) 
				{
					Hospitalizado c=em.getHospitalizado();
					//c.guardar(); 	
				}
			}
		});
		mnRegistrar1.add(mntmInforme);

		JMenu mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);

		JMenuItem mntmUrgencia = new JMenuItem("Urgencia");
		mntmUrgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emergencia = new Urgencia(listaPacientes);
				System.out.println(listaPacientes.get(0).getNombre());
			}
		});
		
		mnModificar.add(mntmUrgencia);

		JMenuItem mntmRecuperado = new JMenuItem("Recuperado");
		mntmRecuperado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recuperado = new Recuperado (listaHospitalizados);
			}
		});
		mnModificar.add(mntmRecuperado);
		
		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);

		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar_Paciente cp = new Consultar_Paciente(listaPacientes);
			}
		});
		mnConsultar.add(mntmPaciente);

		JMenuItem mntmInformes= new JMenuItem("Estado Medico");
		mntmInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar_Hospitalizados cp = new Consultar_Hospitalizados(listaHospitalizados);
			}
		});
		mnConsultar.add(mntmInformes);

	}
	/*public void leer(){
		String ruta;
		ruta="C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/registro.txt";
		leerTodo = Archivo.leerTodo(ruta);
		}
	public void leer2(){

		String ruta;
		ruta="C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/hospitalizados.txt";
		leerTodo = Archivo.leerTodo(ruta);
		}*/

		
}