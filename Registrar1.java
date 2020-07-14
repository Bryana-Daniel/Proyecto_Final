import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Registrar1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textFR;
	private JTextField textEdad;
	private JTextField textGenero;
	private JTextField textSintomas;
	private boolean validar;
	private AbstractButton rdbtnEnfermo;
	private JRadioButton rdbtnAccidentado;
	public Paciente paciente;
	private boolean cierre;

	/*public static void main(String[] args) {
		try {
			Registrar1 dialog = new Registrar1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public Registrar1() {
		setModal(true);
		setType(Type.POPUP);
		setTitle("Registro de pacientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Registro de pacientes\r\n");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel.setBounds(124, 11, 197, 27);
			contentPanel.add(lblNewLabel);
		}

		{
			JLabel lblNombre = new JLabel("Nombre Completo:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setBounds(10, 53, 109, 14);
			contentPanel.add(lblNombre);
		}

		textNombre = new JTextField();
		textNombre.setBounds(144, 49, 269, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblFechaDeRegistro = new JLabel("Fecha De Registro:");
		lblFechaDeRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeRegistro.setBounds(10, 78, 109, 14);
		contentPanel.add(lblFechaDeRegistro);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEdad.setBounds(10, 103, 46, 14);
		contentPanel.add(lblEdad);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenero.setBounds(10, 128, 46, 14);
		contentPanel.add(lblGenero);

		JLabel lblSintomas = new JLabel("Sintomas:");
		lblSintomas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSintomas.setBounds(10, 153, 46, 14);
		contentPanel.add(lblSintomas);

		textFR = new JTextField();
		textFR.setText("--/--/--");
		textFR.setBounds(144, 75, 269, 20);
		contentPanel.add(textFR);
		textFR.setColumns(10);

		textEdad = new JTextField();
		textEdad.setBounds(144, 100, 269, 20);
		contentPanel.add(textEdad);
		textEdad.setColumns(10);

		textGenero = new JTextField();
		textGenero.setBounds(144, 125, 269, 20);
		contentPanel.add(textGenero);
		textGenero.setColumns(10);

		textSintomas = new JTextField();
		textSintomas.setBounds(144, 150, 269, 20);
		contentPanel.add(textSintomas);
		textSintomas.setColumns(10);

		JLabel lblEnfermoOAccidentado = new JLabel("Enfermo/Accidente:");
		lblEnfermoOAccidentado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnfermoOAccidentado.setBounds(10, 178, 89, 25);
		contentPanel.add(lblEnfermoOAccidentado);

		rdbtnEnfermo = new JRadioButton("Enfermo");
		rdbtnEnfermo.setBounds(109, 174, 109, 23);
		contentPanel.add(rdbtnEnfermo);

		rdbtnAccidentado = new JRadioButton("Accidentado");
		rdbtnAccidentado.setBounds(229, 174, 109, 23);
		contentPanel.add(rdbtnAccidentado);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				validar();
				if (validar == false) {
					JOptionPane.showMessageDialog(null, "DEBE DE LLENAR TODOS LOS CAMPOS","ALERTA", JOptionPane.WARNING_MESSAGE);
				}
				if (validar == true) {
					JOptionPane.showMessageDialog(null, "GUARDADO EXITOSO", "CUENTA AGREGADA", JOptionPane.WARNING_MESSAGE);
				
				String Nombre = textNombre.getText();
				String e_e="";
				if (rdbtnEnfermo.isSelected()) 
					e_e="Enfermo";
				else 
					if (rdbtnAccidentado.isSelected()) 
						e_e="Accidentado";

				String nombre = textNombre.getText();
				String fecha=textFR.getText();
				String edadString=textEdad.getText();
				int edad = Integer.parseInt(edadString);
				String genero =textGenero.getText();
				String sintomas=textSintomas.getText();
				paciente = new Paciente (nombre, fecha, edad, genero, sintomas, e_e);
				cierre=true;
				setVisible(false);
				dispose();

				}

			}
		});
		btnRegistrar.setBounds(304, 204, 109, 36);
		contentPanel.add(btnRegistrar);
		
		JButton btnNewButton = new JButton("CANCELAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cierre=false;
				setVisible(false);
			}
		});
		btnNewButton.setBounds(185, 204, 109, 36);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			setVisible(true);
		}
	}
	public boolean validar() {
		if (!rdbtnEnfermo.isSelected() && !rdbtnAccidentado.isSelected() || textNombre.getText().equals("") || textFR.getText().equals("") || textEdad.getText().equals("") || textGenero.getText().equals("") || textSintomas.getText().equals(""))
		{
			validar=false;
		}
		else 
			validar=true;

		return validar;
	}

	public Paciente getPaciente() {

		return paciente;
	}

	public boolean getCierre() {

		return cierre;
	}
}