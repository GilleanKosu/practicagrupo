import java.util.*;

public class PracticaGrupoMain {
	
	public static void muestraMenu () {
		System.out.println(" 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificaci�n trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
	}
	
	//M�todo hecho por: Daniel Moreno Navarro
	public static void altaAlumno (ArrayList<Alumno> alumnos) throws Exception {
		
		Scanner entrada = new Scanner(System.in);
		
		//Creamos un alumno "nuevoAlumno" y pedimos el DNI
		System.out.println("DNI del alumno:");
		Alumno nuevoAlumno = new Alumno(entrada.nextLine());
		
		//Pedimos nombre
		System.out.println("Nombre del alumno:");
		nuevoAlumno.setNombre(entrada.nextLine());
		
		//Pedimos apellidos
		System.out.println("Apellidos del alumno:");
		nuevoAlumno.setApellidos(entrada.nextLine());
		
		//Tel�fomo
		System.out.println("Tel�fono del alumno:");
		nuevoAlumno.setTelefono(entrada.nextLine());
		
		//Email
		System.out.println("Email del alumno:");
		nuevoAlumno.setEmail(entrada.nextLine());
		
		//Comprobamos que el alumno no est� ya en el ArrayList. Si est�, devolvemos la excepci�n
		//y si no est�, lo a�adimos
		if(alumnos.contains(nuevoAlumno)) {
			throw new Exception ("Error. El alumno ya existe.");
		}else {
		alumnos.add(nuevoAlumno);
		System.out.println("Alumno a�adido.");
		}
	}

	//M�todo hecho por: Daniel Moreno Navarro
	public static void bajaAlumno (ArrayList<Alumno> alumnos) throws Exception{
		
		Scanner entrada = new Scanner(System.in);
		
		//Variables
		String numero;
		boolean contiene = false;
		
		//Primero mostramos la lista con los alumnos que tenemos
		listarAlumnos(alumnos);
		
		//Comprobamos que no est� vac�o el ArrayList, si est� vac�o, no seguimos con el proceso 
		if (alumnos.isEmpty() == false) {
		
			System.out.println("DNI del alumno que desea dar de baja:");//Guardamos el DNI en la variable "numero" 
			numero = entrada.nextLine();
			
			//Con un buble for recorreremos el ArrayList hasta que el dni indicado coincida con alg�n dni dentro de la lista
			for(int i = 0; i < alumnos.size()&& contiene == false; i++) {
				
				if(alumnos.get(i).getDni().equals(numero)) {
						
					contiene = true;//de haber encontrado el dni indicado, cambiamos contiene a "true" para que no contin�e el bucle
						
					alumnos.remove(i);//Eliminamos el alumno en la posici�n "i"
						
					System.out.println("Alumno eliminado con �xito.");
				}
			}
				
			//Si contiene sigue siendo "false", significa que el dni no se ha encontrado en 
			//el ArrayList, as� que lanzamos una excepci�n
			if(contiene == false) {
				throw new Exception("El DNI introducido no est� en la lista.");
			}
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
		ArrayList <Alumno> alumnos = new ArrayList <Alumno>();
		
		//Menu
		while (controlaMenu==false) {//Variable que controla que el menu se muestre y se repita
			
			Scanner teclado = new Scanner(System.in);
			
			muestraMenu();//Muestra las opciones
			
			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt(); //Opcion elegida del menu
			
			switch (opcionMenu) {
			
				case 1:
					
					Scanner entrada1 = new Scanner(System.in);
					
					boolean repetir1 = true;
					int opcion1;
					
					do {
						
						try {			
							PracticaGrupoMain.altaAlumno(alumnos);
						} catch (Exception ex) {
						System.out.println(ex.getMessage());
						}System.out.println();
						
						System.out.println("�A�adir nuevo alumno?");
						System.out.println("1. S� - 2. No");
						opcion1 = entrada1.nextInt();
						
						switch(opcion1) {
						
						case 1:
							
							System.out.println();
							
							break;
							
						case 2:
							
							System.out.println("Fin de la operaci�n.");
							System.out.println();
							repetir1 = false;
							
							break;
							
						default:
							
							System.out.println("Opci�n incorrecta.");
							repetir1 = false;
							
						}
					}while(repetir1 == true);
					
					break;
					
				case 2:
					
					Scanner entrada2 = new Scanner(System.in);
					
					boolean repetir2 = true;
					int opcion2;
					
					do {
						
						try {			
								PracticaGrupoMain.bajaAlumno(alumnos);
											
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}System.out.println();
						
						System.out.println("�Dar de baja otro alumno?");
						System.out.println("1. S� - 2. No");
						opcion1 = entrada2.nextInt();
						
						switch(opcion1) {
							
							case 1:
								
								System.out.println();
								
								break;
								
							case 2:
								
								System.out.println("Fin de la operaci�n.");
								System.out.println();
								repetir1 = false;
								
								break;
								
							default:
								
								System.out.println("Opci�n incorrecta.");
								repetir1 = false;
								
							}
					}while(repetir2 == true);
								
					break;
					
				case 3:
					
					listarAlumnos(alumnos);
					
					break;
					
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

