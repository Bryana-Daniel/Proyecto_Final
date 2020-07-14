import java.io.*;

public class Hospitalizado {
	private String nombre1;
	private String enfermedad;
	private String tratamiento;
	public String datosPaciente; 
	
	public Hospitalizado(String nombre1, String enfermedad,String tratamiento) {
		super();
		this.nombre1 = nombre1;
		this.enfermedad = enfermedad;
		this.tratamiento = tratamiento;

		datosPaciente = (nombre1 + enfermedad + tratamiento);
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getNombre1() {
		return this.nombre1;
	}
	public String getEnfermedad() {
		return this.enfermedad;
	}
	public String getTratamiento() {
		return this.tratamiento;
	}


	
}