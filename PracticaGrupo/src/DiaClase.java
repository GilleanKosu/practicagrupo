//Autor: Antonio Garcia Illescas
public class DiaClase {
	
	//Variables
	
	private Fecha dia;
	private Horario sesiones;
	
	
	//Constructores
	
	public DiaClase (Fecha dia) {
		this.sesiones = new Horario ();
		try {
			this.dia = new Fecha(dia.getDia(), dia.getMes(), dia.getAgno());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
	}
	
	
	//Metodos
	
	public void setDia (Fecha dia) {
		this.dia = dia;
	}
	
	public Fecha getDia() {
		return this.dia;
	}


	public Horario getHorario() {
		return this.sesiones;
	}


	// Sobrecarga del método equals de la clase Object
	public boolean equals(Object object){
		
		
		boolean igual = false;
		
		if(object instanceof DiaClase){
			
			DiaClase diaClase = (DiaClase) object;
			
			if(diaClase.getDia().equals(this.getDia())) {
				igual = true;
			}
			
		}
		
		return igual;
		
	}
	
	

}
