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
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) throws Exception {
		if (nota != "0" || nota != "1" || nota != "2" || nota != "3" || nota != "4" || nota != "5" || nota != "6"
				|| nota != "7" || nota != "8" || nota != "9" || nota != "10" || nota != "NE")
			throw new Exception("Error: valor no admitido.");

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
