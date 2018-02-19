import java.util.*;



public class PracticaGrupoMain {
	
	//Muestra el menu
	public static void muestraMenu () {
		System.out.println(" 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificación trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
	}
	

	//Método hecho por: Daniel Moreno Navarro
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
		
		//Teléfomo
		System.out.println("Teléfono del alumno:");
		nuevoAlumno.setTelefono(entrada.nextLine());
		
		//Email
		System.out.println("Email del alumno:");
		nuevoAlumno.setEmail(entrada.nextLine());
		
		//Comprobamos que el alumno no esté ya en el ArrayList. Si está, devolvemos la excepción
		//y si no está, lo añadimos
		if(alumnos.contains(nuevoAlumno)) {
			throw new Exception ("Error. El alumno ya existe.");
		}else {
		alumnos.add(nuevoAlumno);
		System.out.println("Alumno añadido.");
		}
	}

	//Método hecho por: Daniel Moreno Navarro
	public static void bajaAlumno (ArrayList<Alumno> alumnos) throws Exception{
		
		Scanner entrada = new Scanner(System.in);
		
		//Variables
		String numero;
		boolean contiene = false;
		
		//Primero mostramos la lista con los alumnos que tenemos
		listarAlumnos(alumnos);
		
		//Comprobamos que no esté vacío el ArrayList, si está vacío, no seguimos con el proceso 
		if (alumnos.isEmpty() == false) {
		
			System.out.println("DNI del alumno que desea dar de baja:");//Guardamos el DNI en la variable "numero" 
			numero = entrada.nextLine();
			
			//Con un buble for recorreremos el ArrayList hasta que el dni indicado coincida con algún dni dentro de la lista
			for(int i = 0; i < alumnos.size()&& contiene == false; i++) {
				
				if(alumnos.get(i).getDni().equals(numero)) {
						
					contiene = true;//de haber encontrado el dni indicado, cambiamos contiene a "true" para que no continúe el bucle
						
					alumnos.remove(i);//Eliminamos el alumno en la posición "i"
						
					System.out.println("Alumno eliminado con éxito.");
				}
			}
				
			//Si contiene sigue siendo "false", significa que el dni no se ha encontrado en 
			//el ArrayList, así que lanzamos una excepción
			if(contiene == false) {
				throw new Exception("El DNI introducido no está en la lista.");
			}
		}
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
	//Ver si tenemos alumnos en el arraylist y, si no está vacío, 
	//mostraremos los alumnos (datos básicos: dni, apellidos, nombre)
	public static void listarAlumnos(ArrayList<Alumno> alumnos) {
		if(alumnos.size()>0) {//En caso de que no esté vacío, recorremos el ArrayList y mostramos algunos datos
			System.out.println("\nListado de alumnos: ");
			for(int i=0; i<alumnos.size(); i++) {
				System.out.println(alumnos.get(i).getDni()+" "+alumnos.get(i).getApellidos()+", "+alumnos.get(i).getNombre());
			}
		}
		else
			System.out.println("Sin alumnos registrados");
	}
	
	//hecho por:juanra
	//pasar lista y poner falta aquel alunmo que no este.
	public static void pasarLista(ArrayList<Alumno> lista) {
		Scanner entrada=new Scanner(System.in);
		int hora;
		int esta;
		for (int i = 0; i < lista.size(); i++) {//recorrerá lista de alumnos.
			try{
				lista.contains(i);//si no existe el alunmo lanzara un mensaje.
			}catch(Exception ex) {
				System.out.println("Alumno no existe");
			}
			System.out.println("Alunmno: "+lista.get(i));//obtendremos el alumno.
			System.out.println("¿Esta?");
			System.out.println("pulsa cualquier tecla para si o 0 para no");
			esta=entrada.nextInt();
			if(esta==0) {//si no esta pediremos el dia y la hora que ha faltado.
				System.out.println("introduce dia");
				int dia=entrada.nextInt();
				do {
					System.out.println("¿que hora ha faltado?");
					hora=entrada.nextInt();//introduce hora que ha faltado y la asigna.
				}while(hora>=0 && hora<6);
				lista.get(i).getFaltas().get(dia).getHorario().faltaHora(hora);
			}
		}
	}
	//hecho por:juanra.
	public static void listarFaltas(ArrayList<Alumno> lista){
		for (int i = 0; i < lista.size(); i++) {//recorrerá lista de alumnos.
			try{
				lista.get(i);
			}catch(Exception ex) {
				System.out.println("Alumno no existe");
			}
			ArrayList<DiaClase> faltas = lista.get(i).getFaltas();//obtenemos lista faltas
			System.out.println(faltas.get(i).getHorario().getSesiones());//imprimimos faltas.
			}
	}

	//Pregunta si se quiere repetir la operacion y devuelve true si el usuario ha indicado que sí,
	//false en caso contrario
	public static boolean repetimos() {
		//Declaración de variables
		Scanner entrada = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("¿Desea realizar de nuevo la operación?");
			System.out.println("1. SI");
			System.out.println("2. NO");
			opcion=entrada.nextInt();
			entrada.nextLine();//Limpiar buffer
			if(opcion!=1 && opcion!=2)
				System.out.println("Opcion incorrecta. Debe elegir 1 o 2. Pruebe de nuevo");
		}while(opcion!=1 && opcion!=2);
		
		if(opcion==1)
			return true;
		else
			return false;
	}
	
	//Autor modificarAlumno: Daniel Garrido Castro
	//Muestra la lista de alumnos, pide cuál se quiere modificar
	public static void modificarAlumno(ArrayList<Alumno> alumnos) throws Exception {
		//Declaración de variables
		Scanner entrada = new Scanner(System.in);
		String dni = new String();//donde guardar el dni del alumno a modificar
		String aux = new String();//usada para modificar datos del alumno
		int opcion;
		
		//Muestra la lista de alumnos
		listarAlumnos(alumnos);
		
		//Pide cuál se quiere modificar
		System.out.println("Introd. el dni del alumno a modificar: ");
		dni=entrada.nextLine();
		
		//Recorro la lista de alumnos para ver si existe el dni
		for(int i=0; i<alumnos.size(); i++) {
		
			if(alumnos.get(i).getDni().equals(dni)) {//Si el dni está en el arraylist
				
				System.out.println("\n¿Que dato quiere modificar del alumno "+dni+"?");
				System.out.println("1. DNI");
				System.out.println("2. Nombre");
				System.out.println("3. Apellidos");
				System.out.println("4. Telefono");
				System.out.println("5. email");
				System.out.println("6. Salir");
				opcion=entrada.nextInt();
				entrada.nextLine();//Limpiar buffer
				
				switch(opcion) {
					case 1:
						System.out.println("Antiguo dni: "+dni+" ¿Cual es el nuevo DNI?");
						aux=entrada.nextLine();
						if(alumnos.contains(new Alumno(aux)))
							throw new Exception("ERROR! El DNI introducido ya pertenece a otro alumno");
						else {
							alumnos.get(i).setDni(aux);
							System.out.println("El dni del alumno ahora es: "+alumnos.get(i).getDni());
						}
						break;
					case 2:
						System.out.println("Antiguo nombre: "+alumnos.get(i).getNombre()+" ¿Cual es el nuevo nombre?");
						aux=entrada.nextLine();
						alumnos.get(i).setNombre(aux);
						System.out.println("El alumno ahora se llama: "+alumnos.get(i).getNombre());
						break;
					case 3:
						System.out.println("Antiguo apellido: "+alumnos.get(i).getApellidos()+" ¿Cual es el nuevo apellido?");
						aux=entrada.nextLine();
						alumnos.get(i).setApellidos(aux);
						System.out.println("El alumno ahora se apellida: "+alumnos.get(i).getApellidos());
						break;
					case 4:
						System.out.println("Antiguo tlf: "+alumnos.get(i).getTelefono()+" ¿Cual es el nuevo telefono?");
						aux=entrada.nextLine();
						alumnos.get(i).setTelefono(aux);
						System.out.println("El tlf del alumno ahora es: "+alumnos.get(i).getTelefono());
						break;
					case 5:
						System.out.println("Antiguo email: "+alumnos.get(i).getEmail()+" ¿Cual es el nuevo email?");
						aux=entrada.nextLine();
						alumnos.get(i).setEmail(aux);
						System.out.println("El email del alumno ahora es: "+alumnos.get(i).getEmail());
						break;
					case 6:
						System.out.println("Ha elegido salir");
						break;
					default:
						System.out.println("Opción incorrecta. Pruebe con una en [1,6]");
				}
			}
			else {
				throw new Exception("No existe el alumno indicado");

			}
		}
	}

	//Autor matricularAlumnos: Daniel Garrido Castro
	//Comprueba que existe el Alumno y que no está matriculado de la asignatura.
	//También comprueba que esa asignatura no esté metida en el arraylist de notas (no lo vamos a matricular de algo donde ya está matriculado).
	//En ese caso, lo matricula
	public static void matricularAlumno(ArrayList<Alumno> alumnos) throws Exception{
		//Declaración de variables
		Scanner entrada = new Scanner(System.in);
		String dni = new String();
		Calificacion calificacionAux;
		ArrayList<Calificacion> notas = new ArrayList<Calificacion>();
		String[] asignaturas= {"FOL", "Sistemas", "Entornos de desarrollo", "Programacion", "Lenguajes de marcas", "Bases de datos"};
		int opcion;
		
		if(alumnos.size()==0)
			throw new Exception("Error!. Aun no hay alumnos en el listado");
		else {
			//Pide cuál se quiere matricular
			System.out.println("Introd. el dni del alumno a matricular: ");
			dni=entrada.nextLine();
			
			if(!alumnos.contains(new Alumno(dni))) {//El alumno no está en el conjunto
				throw new Exception("Error!. No existe el alumno "+dni);
			}
			else {//El alumno sí está, pedimos la asignatura en que lo vamos a matricular
				do {
					System.out.println("¿De qué asignatura se va a matricular?");
					for(int i=0;i<asignaturas.length;i++) {
						System.out.println((i)+" "+asignaturas[i]);
					}
					opcion=entrada.nextInt();
					entrada.nextLine();//Limpiar buffer
					
					if(opcion<0 || opcion>5)
						System.out.println("Debe elegir un valor en [0,5]. Pruebe otra vez");
				}while(opcion<0 || opcion>5);
				
				//Si ya está matriculado de esa asignatura, lanzamos excepción
				for(int i=0; i<alumnos.size();i++) {
					if(alumnos.get(i).getDni().equals(dni))//selecciono el alumno
						notas=alumnos.get(i).getNotas();//tengo las notas, ahora he de mirar si la asignatura ya está entre las del alumno
						for(int j=0;j<notas.size();j++) {
							if(notas.get(j).getAsignatura().equals(asignaturas[i]))
								throw new Exception ("Ya matriculado");
							else {
								calificacionAux= new Calificacion(asignaturas[i]);
								calificacionAux.setNota("NE");
								alumnos.get(i).getNotas().add(calificacionAux);
							}
						}
				}
					
			}
		}
	}
	
	//Autor: Antonio Garcia
	//Pone el dia completo como que ha faltado
	public static void ponerFaltaDiaCompleto (ArrayList <Alumno> alumnos) throws Exception {
		
		//Variables
		String dni;
		int dia, mes, agno;
		
		//Entradas
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Dni");
		dni=entrada.nextLine();
		
		System.out.println("dia");
		dia=entrada.nextInt();
		
		System.out.println("mes");
		mes=entrada.nextInt();
		
		System.out.println("año");
		agno=entrada.nextInt();
		
		Fecha fechaDia = new Fecha (dia, mes, agno);//Creacion del objeto con los datos introducidos
		
		//Preguntamos si existe el alumno
		if (alumnos.contains(new Alumno(dni))) {
			
			//Recorremos el Araylist de Alumno
			for (int i = 0; i < alumnos.size(); i++) {
				
				//Recorremos el ArrayList de las faltas
				for (int j = 0; j < alumnos.get(i).getFaltas().size(); j++) {
					
					//Preguntamos que dia coindice con el intoducido
					if (alumnos.get(i).getFaltas().get(j).getDia() == fechaDia) {
						
						alumnos.get(i).getFaltas().get(j).getHorario().faltaDiaEntero(); //Le ponemos las faltas de ese dia
						
					}
				}
				
			}
			
		} else {
			throw new Exception ("No existe el alumno");
		}

	}
	
	
	//Autor: Antonio Garcia
	//Pone la falta de la hora en concreto
	public static void ponerFaltasSesion(ArrayList <Alumno> alumnos) throws Exception {
		
		//Variables
		
		String dni;
		int dia, mes, agno, horaFalta;
		
		//Entradas
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Dni");
		dni=entrada.nextLine();
		
		System.out.println("dia");
		dia=entrada.nextInt();
		
		System.out.println("mes");
		mes=entrada.nextInt();
		
		System.out.println("año");
		agno=entrada.nextInt();
		
		System.out.println("Hora de la falta");
		horaFalta=entrada.nextInt();
		
		
		Fecha fechaDia = new Fecha (dia, mes, agno);//Creacion del objeto con los datos introducidos
		
		//Preguntamos si existe el alumno
		if (alumnos.contains(new Alumno(dni))) {
			
			//Recorremos el Araylist de Alumno
			for (int i = 0; i < alumnos.size(); i++) {
				
				//Recorremos el ArrayList de las faltas
				for (int j = 0; j < alumnos.get(i).getFaltas().size(); j++) {
					
					//Preguntamos que dia coindice con el intoducido
					if (alumnos.get(i).getFaltas().get(j).getDia() == fechaDia) {
						
						alumnos.get(i).getFaltas().get(j).getHorario().faltaHora(horaFalta);//Le ponemos las faltas de esa hora
						
					}
				}
				
			}
			
		} else {
			throw new Exception ("No existe el alumno");
		}
	}

	
	public static void main(String[] args) {
		
		// Variables
		int opcionMenu;
		boolean controlaMenu=false;

		ArrayList <Alumno> alumnos = new ArrayList <Alumno>();

		
		boolean repetir=false;

		
		

		//Menu
		while (controlaMenu==false) {//Variable que controla que el menu se muestre y se repita
			
			Scanner teclado = new Scanner(System.in);
			
			muestraMenu();//Muestra las opciones
			
			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt(); //Opcion elegida del menu
			teclado.nextLine();
			
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
						
						System.out.println("¿Añadir nuevo alumno?");
						System.out.println("1. Sí - 2. No");
						opcion1 = entrada1.nextInt();
						
						switch(opcion1) {
						
						case 1:
							
							System.out.println();
							
							break;
							
						case 2:
							
							System.out.println("Fin de la operación.");
							System.out.println();
							repetir1 = false;
							
							break;
							
						default:
							
							System.out.println("Opción incorrecta.");
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
						
						System.out.println("¿Dar de baja otro alumno?");
						System.out.println("1. Sí - 2. No");
						opcion1 = entrada2.nextInt();
						
						switch(opcion1) {
							
							case 1:
								
								System.out.println();
								
								break;
								
							case 2:
								
								System.out.println("Fin de la operación.");
								System.out.println();
								repetir1 = false;
								
								break;
								
							default:
								
								System.out.println("Opción incorrecta.");
								repetir1 = false;
								
							}
					}while(repetir2 == true);
								
					break;
		
		//Listar los alumnos		
				case 3:

					listarAlumnos(alumnos);

					break;
		
		//Modificar alumnos			
				case 4:

					repetir=true;
					while(repetir) {
						try {
							modificarAlumno(alumnos);
						}catch(Exception ex) {
							System.out.println(ex.getMessage());
						}
						repetir=repetimos();
					}

					break;
		
		//Matricular alumnos		
				case 5:
					repetir=true;
					while(repetir) {
						try {
							matricularAlumno(alumnos);
						}catch(Exception ex) {
							System.out.println(ex.getMessage());
						}
						repetir=repetimos();
					}
					break;
					
				case 6:
					
					break;
					
				case 7:
					
					break;
					
				case 8:
					
					break;
					
				case 9:
					try {
						
						ponerFaltaDiaCompleto (alumnos);
						
					} catch (Exception ex) {

						ex.getMessage();
						
					}
					
					listarFaltas(alumnos);
					
					break;
					
				case 10:
					
					try {
						
						ponerFaltasSesion (alumnos);
						
					} catch (Exception ex) {

						ex.getMessage();
						
					}
					
					listarFaltas(alumnos);
					
					break;
					//pasar lista.
				case 11:
					// Llamamos al metodo
					
					try {
						pasarLista(alumnos);
					} catch (Exception ex){
						System.out.println(ex.getMessage());
					}
					
					break;
					//listar faltas.
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

