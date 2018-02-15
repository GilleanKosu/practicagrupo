import java.util.ArrayList;
import java.util.Scanner;

public class PracticaGrupoMain {
	
	//Muestra el menu
	public static void muestraMenu () {
		System.out.println(" 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificación trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
	}
	
	//Compara si existe un elemento en concreto de tipo Fecha en el arraylist introducido
	public static boolean existeFecha (Fecha fecha, ArrayList <Fecha> arrayFechas) {
		
		if (arrayFechas.contains(fecha)) {
			return true;
		} else {
			return false;
		}
	}
	
	//Compara si existe un elemento en concreto de tipo Horario en el arraylist introducido(Puede que no sea necesario)
	public static boolean existeHorario (Horario horario, ArrayList <Horario> arrayHorario) {
		if (arrayHorario.contains(horario)) {
			return true;
		} else {
			return false;
		}
	}
	
	//Comprara si existe un elemento en concreto de tipo DiaClase en el arraylist introducido
	public static boolean existeDiaClase (DiaClase dia, ArrayList <DiaClase> arrayDiasClase) {
		
		if (arrayDiasClase.contains(dia)) {
			return true;
		} else {
			return false;
		}
	}
	
	//Compara si existe un elemento en concreto de tipo Calificacion en el arraylist
	public static boolean existeCalificacion (Calificacion calificacion, ArrayList <Calificacion> arrayCalificacion) {
		
		if (arrayCalificacion.contains(calificacion)) {
			return true;
		} else {
			return false;
		}
	}
	
	//Compara si existe un elemento de tipo Alumno en el arraylist introducido
	public static boolean existeAlumno (Alumno alumno, ArrayList <Alumno> arrayAlumnos) {
		if (arrayAlumnos.contains(alumno)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		// Variables
		int opcionMenu;
		boolean controlaMenu=false;
		
		
		//Menu
		while (controlaMenu==false) {//Variable que controla que el menu se muestre y se repita
			
			Scanner teclado = new Scanner(System.in);
			
			muestraMenu();//Muestra las opciones
			
			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt(); //Opcion elegida del menu
			
			switch (opcionMenu) {
			
				case 1:
					
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				case 4:
					
					break;
					
				case 5:
					
					break;
					
				case 6:
					
					break;
					
				case 7:
					
					break;
					
				case 8:
					
					break;
					
				case 9:
					
					break;
					
				case 10:
					
					break;
					
				case 11:
					
					break;
					
				case 12:
					
					break;
				
				//Salir
				case 13:
					
					controlaMenu=true;
					
					break;
				
				//Opcion por defecto
				default:
					
					System.out.println("No se ha introducido ninguna de las opciones del menu");
					break;
					
			}
			
		}

		
	}

}
