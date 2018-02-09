// Danut Moldovan
public class Calificacion {

	
	// Variables
	String asignatura;
	String nota;

	// Métodos

	// Constructor

	public Calificacion(String asignatura) {
		this.asignatura = new String(asignatura);
	}

	// Getters y setters

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	// Sobrecarga del método equals de la clase Object
	public boolean equals(Object object) {
		boolean igual = false;
		if (object instanceof Calificacion) {
			Calificacion calificacion = (Calificacion) object;
			if (calificacion.getAsignatura().equalsIgnoreCase(this.getAsignatura()))
				igual = true;
		}
		return igual;
	}

}
