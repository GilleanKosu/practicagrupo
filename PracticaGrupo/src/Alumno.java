//Autor: Daniel Garrido

import java.util.ArrayList;

public class Alumno {
	//Atributos
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private ArrayList<DiaClase> faltas;//Contiene las faltas del Alumno para 1 dia de clase (6 horas)
	private ArrayList<Calificacion> notas;//Contiene las notas del alumno (6 notas)
	
	//Constructor que asigna dni y crea los ArrayLists.
	public Alumno(String dni) {
		this.dni = new String(dni);
		this.faltas = new ArrayList<DiaClase>();
		this.notas = new ArrayList<Calificacion>();
	}
	//Constructor que asigna dni, nombre y apellidos del alumno y crea los ArrayLists.
	public Alumno(String dni, String nombre, String apellidos) {
		this.dni = new String(dni);
		this.nombre = new String(nombre);
		this.apellidos = new String(apellidos);
		this.faltas = new ArrayList<DiaClase>();
		this.notas = new ArrayList<Calificacion>();
	}
	//Getters (devuelven el atributo correspondiente)
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public ArrayList<DiaClase> getFaltas() {
		return this.faltas;
	}
	
	public ArrayList<Calificacion> getNotas() {
		return this.notas;
	}
	
	//Setters (asignan el valor recibido como argumento al atributo de la clase)
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Sobrecarga del método equals de la clase Object
	public boolean equals(Object object){
		boolean igual = false;

		if(object instanceof Alumno){
			Alumno alumno = (Alumno) object;
			if(alumno.getDni().equalsIgnoreCase(this.getDni())) {
				igual = true;
			}
		}
		return igual; 
	}
	
}
