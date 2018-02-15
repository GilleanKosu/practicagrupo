import java.util.ArrayList;
import java.util.Scanner;

public class PracticaGrupoMain {
	
	//Muestra el menu
	public static void muestraMenu () {
		System.out.println(" 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificaci�n trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
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

	
	//Autor listarAlumnos: Daniel Garrido Castro
	//Ver si tenemos alumnos en el arraylist y, si no est� vac�o, 
	//mostraremos los alumnos (datos b�sicos: dni, apellidos, nombre)
	public static void listarAlumnos(ArrayList<Alumno> alumnos) {
		if(alumnos.size()>0) {//En caso de que no est� vac�o, recorremos el ArrayList y mostramos algunos datos
			System.out.println("\nListado de alumnos: ");
			for(int i=0; i<alumnos.size(); i++) {
				System.out.println(alumnos.get(i).getDni()+" "+alumnos.get(i).getApellidos()+", "+alumnos.get(i).getNombre());
			}
		}
		else
			System.out.println("Sin alumnos registrados");
	}

	//Autor modificarAlumno: Daniel Garrido Castro
	//Muestra la lista de alumnos, pide cu�l se quiere modificar
	public static void modificarAlumno(ArrayList<Alumno> alumnos) throws Exception {
		//Declaraci�n de variables
		Scanner entrada = new Scanner(System.in);
		String dni = new String();
		
		//Muestra la lista de alumnos
		listarAlumnos(alumnos);
		
		//Pide cu�l se quiere modificar
		System.out.println("Introd. el dni del alumno a modificar: ");
		dni=entrada.nextLine();
		
		//Recorro la lista de alumnos para ver si existe el dni
		for(int i=0; i<alumnos.size(); i++) {
		
			if(alumnos.get(i).getDni().equals(dni)) {//Si el dni est� en el arraylist
				
			}
			else {
				throw new Exception("No existe el alumno indicado");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		// Variables
		int opcionMenu;
		boolean controlaMenu=false;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		
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
		
		//Listar los alumnos		
				case 3:
					listarAlumnos(alumnos);
					break;
		
		//Modificar alumnos			
				case 4:
					boolean algo=false;
					while(!algo) {
						try {
							modificarAlumno(alumnos);
							algo=true;
						}catch(Exception ex) {
							ex.getMessage();
						}
					}


					break;
		
		//Matricular alumnos		
				case 5:
					//matricularAlumno(alumno);
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
