


import java.util.ArrayList;

//Autor de la clase Fecha: Daniel Moreno Navarro

public class Fecha {

	//Variables de la clase
	private int dia;
	private int mes;
	private int agno;
	
	//M�todo constructor, que devuelve mensajes de error si el d�a, mes o a�o no son correctos
	public Fecha (int dia, int mes, int agno)  throws Exception{
		
		if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 
				|| mes == 10 || mes == 12) && (dia < 1 || dia > 31)) {
			throw new Exception("D�a incorrecto (Debe estar entre 1 y 31).");
		}
			
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11 && dia < 1 || dia > 30) {
			throw new Exception("D�a incorrecto (Debe estar entre 1 y 30).");
		}
		if(mes == 2 && dia < 1 || dia > 28) {
			throw new Exception("D�a incorrecto (Debe estar entre 1 y 28).");
		}
		if(mes < 1 || mes > 12 ) {
			throw new Exception("Mes incorrecto (Debe estar entre 1 y 12).");
		}
		if(agno < 2016) {
			throw new Exception("A�o incorrecto (A�o anterior a 2016.");
		}
	
		this.dia = dia;
		this.mes = mes;
		this.agno = agno;
		
	}
	
	//M�todo por defecto, que inicializa la fecha al 1/1/2016
	public Fecha () {
		
		this.dia = 1;
		this.mes = 1;
		this.agno = 2016;
		
	}
	
	//M�todos getters
	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}
	
	public int getAgno() {
		return this.agno;
	}

	//M�todo para devolver la fecha
	public void imprimeFecha() {
		
		System.out.println(this.dia + "/" + this.mes + "/" + this.agno);
		
	}
	
	//M�todo equals
	public boolean equals(Object object) {
		boolean igual = false;
		
		if (object instanceof Fecha) {
			Fecha fecha = (Fecha) object;
			if (fecha.getDia() == this.getDia() && fecha.getMes() == this.getMes() 
					&& fecha.getAgno() == this.getAgno())
				igual = true;
		}
		return igual;
		
	}
	
}
