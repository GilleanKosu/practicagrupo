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

	public void setNota(String nota) throws Exception {

		if (!nota.equals("0") && !nota.equals("1") && !nota.equals("2") && !nota.equals("3") && !nota.equals("4")
				&& !nota.equals("5") && !nota.equals("6") && !nota.equals("7") && !nota.equals("8") && !nota.equals("9")
				&& !nota.equals("10") && !nota.equals("NE"))
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