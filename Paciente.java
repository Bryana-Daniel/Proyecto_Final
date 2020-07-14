import java.io.*;

public class Paciente {
	private String nombre;
	private String fecha;
	private int edad;
	private String genero;
	private String sintomas;
	private String e_e;
	public String datosPaciente; 

	public Paciente(String nombre, String fecha, int edad, String genero, String sintomas, String e_e) {

     	this.nombre = nombre;
		this.fecha = fecha;
		this.edad = edad;
		this.genero = genero;
		this.sintomas = sintomas;
		this.e_e = e_e;
		//this.datosPaciente = datosPaciente;

		datosPaciente = (nombre + fecha + edad + genero +  sintomas + e_e);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public void setE_e(String e_e) {
		this.e_e = e_e;
	}

	public String getNombre() {
		return this.nombre;
	}
	public String getFecha() {
		return this.fecha;
	}
	public int getEdad() {
		return this.edad;
	}
	public String getGenero() {
		return this.genero;
	}
	public String getSintomas() {
		return this.sintomas;
	}
	public String getE_e() {
		return this.e_e;
	}



}