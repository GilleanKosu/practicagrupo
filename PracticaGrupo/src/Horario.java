<<<<<<< HEAD


=======
//Autor: Juanra
>>>>>>> d150891fbd766c1fd3e9459185dbd3527fe25fa4
public class Horario {
	
	//ATRIBUTOS
	
	private char sesiones[]=new char[6];
	
	//CONSTRUCTOR
	
	public Horario() {
		sesiones[0]=' ';
		sesiones[1]=' ';
		sesiones[2]=' ';
		sesiones[3]=' ';
		sesiones[4]=' ';
		sesiones[5]=' ';
	}
	
	//metodo getSesiones
	
	public char[] getSesiones() {
		return sesiones;
	}
	
	//metodo faltaDiaEntero
	
	public void faltaDiaEntero() {//asignara a todas las horas falta.
		for(int i=0;i<6;i++){
			sesiones[i]='F';
		}
		
	}
	
	//metodo faltaHora
	
	public void faltaHora(int sesion) {
		try{
			sesiones[sesion-1]='F';
		}catch (Exception ex){
			System.out.println("Valor entre 1 y 6. :" + ex.getMessage());
		}
	}
	
	//metodo imprimeHorario
	
	public void imprimeHora() {
		for(int i=0;i<sesiones.length;i++) {
			System.out.println(sesiones[i]+"/");
		}
	}
	
	
	//AUTOR: JUAN RAMON GARCIA PEREZ
	

	

}
