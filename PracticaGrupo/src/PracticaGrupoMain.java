import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

public class PracticaGrupoMain {

	// Muestra el menu
	public static void muestraMenu() {
		System.out.println(
				"\n 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificaci�n trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
	}

	
	// M�todo hecho por: Daniel Moreno Navarro
	//M�todo para ordenar alfabeticamente los alumnos que se van a�adiendo

	public static void ordenarAlumnos(ArrayList<Alumno> alumnos, Alumno NuevoAl) {

		//Variables
		boolean parar = false;
		int posicion = 0;

		//comprobamos el Array, si no hay alumnos, lo a�adimos directamente
		if (alumnos.isEmpty()) {	
			alumnos.add(NuevoAl);
		} else {
			
			//recorremos el arrayList y vamos comparando los apellidos. En el momento en el que 
			//el apellido del alumno que se va a a�adir es menor que el apellido en la posicion 'i', guardamos la
			//posicion 'i' y paramos el bucle 
			for (int i = 0; i < alumnos.size() && parar == false; i++) {
				
				posicion = i;
				
				if (NuevoAl.getApellidos().compareToIgnoreCase(alumnos.get(i).getApellidos()) < 0) {
					
					parar = true;
					
					/* Para Pruebas
					System.out.println("Numero: " + NuevoAl.getApellidos().compareToIgnoreCase(alumnos.get(i).getApellidos()));
					System.out.println("posicion: " + i);*/
					
				}
			}
			
			//Si el buble se ha parado en algun momento, a�aadimos el alumno en esa posicion
			if (parar) {
				alumnos.add(posicion, NuevoAl);	
				
			//Si 'parar' no es 'true', significa que el for ha seguido hasta el final y que
			//el apellido es el �ltimo, asi que lo a�adimos despu�s de posici�n
			} else {
					
				alumnos.add(posicion + 1, NuevoAl);
			}

		}
	}

	// M�todo hecho por: Daniel Moreno Navarro
	// Introducimos los datos del alumno que queremos dar de alta en nuestra lista
	public static void altaAlumno(ArrayList<Alumno> alumnos) throws Exception {

		Scanner entrada = new Scanner(System.in);

		
		// Creamos un alumno "nuevoAlumno" y pedimos el DNI
		System.out.println("DNI del alumno:");
		Alumno nuevoAlumno = new Alumno(entrada.nextLine());

		// Pedimos nombre
		System.out.println("Nombre del alumno:");
		nuevoAlumno.setNombre(entrada.nextLine());

		// Pedimos apellidos
		System.out.println("Apellidos del alumno:");
		nuevoAlumno.setApellidos(entrada.nextLine());

		// Tel�fomo
		System.out.println("Tel�fono del alumno:");
		nuevoAlumno.setTelefono(entrada.nextLine());

		// Email
		System.out.println("Email del alumno:");
		nuevoAlumno.setEmail(entrada.nextLine());

		// Comprobamos que el alumno no est� ya en el ArrayList. Si est�, devolvemos la
		// excepci�n
		// y si no est�, lo a�adimos, llamando al m�todo ordenarAlumnos para que se vayan
		//incluyendo en el arrayList por orden alfab�tico.
		if (alumnos.contains(nuevoAlumno)) {
			
			throw new Exception("Error. El alumno ya existe.\n");
			
		} else {
			
			ordenarAlumnos(alumnos, nuevoAlumno);
			
			System.out.println("Alumno a�adido.\n");
			
		}
	}

	// M�todo hecho por: Daniel Moreno Navarro
	// Eliminamos a ese alumno de nuestra lista
	
	public static void bajaAlumno(ArrayList<Alumno> alumnos) throws Exception {

		Scanner entrada = new Scanner(System.in);

		// Variables
		String numero;
		boolean contiene = false;

		// Primero mostramos la lista con los alumnos que tenemos
		listarAlumnos(alumnos);

		// Comprobamos que no est� vac�o el ArrayList, si est� vac�o, no seguimos con el
		// proceso
		if (alumnos.isEmpty() == false) {

			System.out.println("DNI del alumno que desea dar de baja:");// Guardamos el DNI en la variable "numero"
			numero = entrada.nextLine();

			// Con un buble for recorreremos el ArrayList hasta que el dni indicado coincida
			// con alg�n dni dentro de la lista
			for (int i = 0; i < alumnos.size() && contiene == false; i++) {

				if (alumnos.get(i).getDni().equals(numero)) {

					contiene = true;// de haber encontrado el dni indicado, cambiamos contiene a "true" para que no
									// contin�e el bucle

					alumnos.remove(i);// Eliminamos el alumno en la posici�n "i"

					System.out.println("Alumno eliminado con �xito.");
				}
			}

			// Si contiene sigue siendo "false", significa que el dni no se ha encontrado en
			// el ArrayList, as� que lanzamos una excepci�n
			if (contiene == false) {
				throw new Exception("El DNI introducido no est� en la lista.");
			}
		}
	}


	// Autor: Puri Amoros (Antonio solo ha modificado el mensaje del DNI)
	// Comprobar si existe el alumno
	public static int existeAlumno(ArrayList<Alumno> arrayAlumnos) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduzca el dni:");
		String dni = entrada.nextLine();

		Alumno aBuscar = new Alumno(dni);

		int posicion = arrayAlumnos.indexOf(aBuscar);

		return posicion;

	}

	// Autor listarAlumnos: Daniel Garrido Castro
	// Ver si tenemos alumnos en el arraylist y, si no est� vac�o,
	// mostraremos los alumnos (datos b�sicos: dni, apellidos, nombre)
	public static void listarAlumnos(ArrayList<Alumno> alumnos) throws Exception {
		if (alumnos.size() > 0) {// En caso de que no est� vac�o, recorremos el ArrayList y mostramos algunos
									// datos
			System.out.println("\nListado de alumnos: ");
			System.out.println("\nHay " + alumnos.size() + " alumnos: ");
			for (int i = 0; i < alumnos.size(); i++) {
				System.out.println(alumnos.get(i).getDni() + " " + alumnos.get(i).getApellidos() + ", "
						+ alumnos.get(i).getNombre());
			}
		} else
			throw new Exception("Sin alumnos dados de alta.");
	}

	// Pregunta si se quiere repetir la operacion y devuelve true si el usuario ha
	// indicado que s�,
	// false en caso contrario
	public static boolean repetimos() {
		// Declaraci�n de variables
		Scanner entrada = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("�Desea realizar de nuevo la operaci�n?");
			System.out.println("1. SI");
			System.out.println("2. NO");
			opcion = entrada.nextInt();
			entrada.nextLine();// Limpiar buffer
			if (opcion != 1 && opcion != 2)
				System.out.println("Opcion incorrecta. Debe elegir 1 o 2. Pruebe de nuevo");
		} while (opcion != 1 && opcion != 2);

		if (opcion == 1)
			return true;
		else
			return false;
	}

	// Autor modificarAlumno: Daniel Garrido Castro
	// Muestra la lista de alumnos, pide cu�l se quiere modificar
	public static void modificarAlumno(ArrayList<Alumno> alumnos) throws Exception {
		// Declaraci�n de variables
		Scanner entrada = new Scanner(System.in);
		String dni = new String();// donde guardar el dni del alumno a modificar
		String aux = new String();// usada para modificar datos del alumno
		int opcion;
		int posicion;
		boolean encontrado = false;


		// Muestra la lista de alumnos
		listarAlumnos(alumnos);

		posicion=existeAlumno(alumnos);
		
		if(posicion==-1) {
			throw new Exception("No existe el alumno indicado");
		}
		
		do {
			System.out.println("\n�Que dato quiere modificar del alumno " + dni + "?");
			System.out.println("1. DNI");
			System.out.println("2. Nombre");
			System.out.println("3. Apellidos");
			System.out.println("4. Telefono");
			System.out.println("5. email");
			System.out.println("6. Salir");
			opcion = entrada.nextInt();
			entrada.nextLine();// Limpiar buffer
			
			switch(opcion) {
			//Cambiar dni
				case 1:
					System.out.println("Antiguo dni: " + dni + " �Cual es el nuevo DNI?");
					aux = entrada.nextLine();
					if (alumnos.contains(new Alumno(aux)))
						throw new Exception("ERROR! El DNI introducido ya pertenece a otro alumno");
					else {
						alumnos.get(posicion).setDni(aux);
						System.out.println("El dni del alumno ahora es: " + alumnos.get(posicion).getDni());
					}
					break;
					
			//Cambiar nombre		
				case 2:
					System.out.println("Antiguo nombre: " + alumnos.get(posicion).getNombre() + " �Cual es el nuevo nombre?");
					aux = entrada.nextLine();
					alumnos.get(posicion).setNombre(aux);
					System.out.println("El alumno ahora se llama: " + alumnos.get(posicion).getNombre());
					break;
					
			//Cambiar Apellidos		
				case 3:
					System.out.println("Antiguo apellido: " + alumnos.get(posicion).getApellidos() + " �Cual es el nuevo apellido?");
					aux = entrada.nextLine();
					alumnos.get(posicion).setApellidos(aux);
					System.out.println("El alumno ahora se apellida: " + alumnos.get(posicion).getApellidos());
					break;
			
			//Cambiar Telefono
				case 4:
					System.out.println("Antiguo tlf: " + alumnos.get(posicion).getTelefono() + " �Cual es el nuevo telefono?");
					aux = entrada.nextLine();
					alumnos.get(posicion).setTelefono(aux);
					System.out.println("El tlf del alumno ahora es: " + alumnos.get(posicion).getTelefono());
					break;
					
			//Cambiar email
				case 5:
					System.out.println("Antiguo email: " + alumnos.get(posicion).getEmail() + " �Cual es el nuevo email?");
					aux = entrada.nextLine();
					alumnos.get(posicion).setEmail(aux);
					System.out.println("El email del alumno ahora es: " + alumnos.get(posicion).getEmail());
					break;
					
			//Salir		
				case 6:
					System.out.println("Ha elegido salir");
					break;
					
			//Opcion incorrecta
				default:
					System.out.println("Opci�n incorrecta. Pruebe con una en [1,6]");
					break;
			}
		}while(opcion!=6);	
	}

	// Autor matricularAlumnos: Daniel Garrido Castro
	// Comprueba que existe el Alumno y que no est� matriculado de la asignatura.
	// Tambi�n comprueba que esa asignatura no est� metida en el arraylist de notas
	// (no lo vamos a matricular de algo donde ya est� matriculado).
	// En ese caso, lo matricula
	public static void matricularAlumno(ArrayList<Alumno> alumnos) throws Exception {
		
		// Declaraci�n de variables
		Scanner entrada = new Scanner(System.in);
		Calificacion calificacionAux;
		String[] asignaturas = { "FOL", "Sistemas", "Entornos de desarrollo", "Programacion", "Lenguajes de marcas", "Bases de datos" };
		int opcion;
		int posicion;
		
		//Si no hay alumnos, no podemos hacer nada... lanzamos excepcion
		if (alumnos.size() == 0)
			throw new Exception("Error!. Aun no hay alumnos en el listado");
		
		//Si llegamos aqu�, si hay alumnos, as� que pedimos el dni a modificar
		posicion=existeAlumno(alumnos);
		
		if(posicion==-1)
			throw new Exception("Error!. No existe el alumno indicado.");
		
		//Si est� el alumno, procedemos
		do {
			System.out.println("�De qu� asignatura se va a matricular?");
			for (int i = 0; i < asignaturas.length; i++) {
				System.out.println((i) + " " + asignaturas[i]);
			}
			opcion = entrada.nextInt();
			entrada.nextLine();// Limpiar buffer

			if (opcion < 0 || opcion > 5)
				System.out.println("Debe elegir un valor en [0,5]. Pruebe otra vez");
		} while (opcion < 0 || opcion > 5);
		
		//Si ya est� matriculado de esa asignatura, lanzo excepci�n, si no, lo matriculo
		if( alumnos.get(posicion).getNotas().contains(asignaturas[opcion]) ) {
			throw new Exception("Ya matriculado");
		}
		//lo matriculo
		calificacionAux = new Calificacion(asignaturas[opcion]);
		calificacionAux.setNota("NE");
		alumnos.get(posicion).getNotas().add(calificacionAux);
	}

	// Dar de baja - Danut Nelu Moldovan
	// Eliminamos la asignatura que elijamos del alumno
	
	public static void darDeBaja(ArrayList<Alumno> alumnos) throws Exception {
		
		// Entradas
		Scanner teclado = new Scanner(System.in);

		// Se declaran variables
		int posicion = existeAlumno(alumnos);
		boolean matriculado = false;

		// Se imprimen las asignaturas en las que est� matriculado si el alumno existe y
		// est� matriculado en alguna asignatura
		if (posicion != -1 && alumnos.get(posicion).getNotas().size() != 0) {
			System.out.println("Asignaturas en las que est� matriculado el alumno:");
			for (int i = 0; i < alumnos.get(posicion).getNotas().size(); i++) {
				System.out.println(alumnos.get(posicion).getNotas().get(i).getAsignatura());
			}
			// Se pide la asignatura
			System.out.println("Introduzca la asignatura a dar de baja.");
			String asignatura = teclado.nextLine();
			// Se recorre el arraylist de notas hasta que se encuentre la asignatura y se
			// borra
			for (int i = 0; i < alumnos.get(posicion).getNotas().size() && (matriculado == false); i++) {
				if (alumnos.get(posicion).getNotas().get(i).getAsignatura().equals(asignatura)) {
					alumnos.get(posicion).getNotas().remove(i);
					System.out.println("El alumno ya no est� matriculado en " + asignatura + ".");
					matriculado = true;
				}
			}
			if (matriculado == false) {
				System.out.println("El alumno no estaba matriculado en " + asignatura + ".");
			}
		} else {
			if (posicion == -1) {
				throw new Exception("Alumno no encontrado.");
			} else {
				if (alumnos.get(posicion).getNotas().size() == 0) {
					throw new Exception("El alumno no est� matriculado en ninguna asignatura.");
				}
			}
		}

	}

	// Calificacion trimestral - Danut Nelu Moldovan
	//Introducimos la nota trimestral de las asignaturas que tenga ese alumno que hemos elegido previamente
	
	public static void ponerCalificacion(ArrayList<Alumno> alumnos) throws Exception {
		Scanner teclado = new Scanner(System.in);
		int posicion = existeAlumno(alumnos);
		
		// Se comprueba si el alumno existe
		if (posicion != -1) {
			
			// Se compueba si el alumno est� matriculado en alguna asignatura.
			if (alumnos.get(posicion).getNotas().size() != 0) {
				
				// Se recorre arraylist de que contiene las notas del alumno y pedimos la nota
				// de cada asignatura
				for (int i = 0; i < alumnos.get(posicion).getNotas().size(); i++) {

					boolean excepcion;
					do {
						try {
							excepcion = false;
							System.out.println(
									"Introduzca la nota de " + alumnos.get(posicion).getNotas().get(i).getAsignatura());
							alumnos.get(posicion).getNotas().get(i).setNota(teclado.nextLine());

						} catch (Exception e) {
							System.out.println(e.getMessage());
							excepcion = true;
						}
					} while (excepcion == true);// Si se introduce un valor no admitido, se vuelve a pedir la nota.

				}
			} else {
				throw new Exception("El alumno no est� matriculado en ninguna asignatura.");
			}

		} else {
			throw new Exception("Alumno no encontrado");
		}

	}

	// Autor: Antonio Garcia
	// Mostramos las calificaciones del alumno que elijamos

	public static void muestraCalificaciones(ArrayList<Alumno> alumnos) throws Exception {

		// Variables
		String dniAlumno;
		int posicionAlumno;

		// Entradas
		Scanner entrada = new Scanner(System.in);

		// Procesos

		if (alumnos.size() == 0) {// Comprobamos si el array esta vacio

			throw new Exception("No hay alumnos de los que mostrar las calificaciones");

		} else {// Si no esta vacio preguntaremos el dni del alumno para mostrar sus datos

			posicionAlumno = existeAlumno(alumnos);

			if (posicionAlumno == -1) {// Si el alumno no esta devolvera -1 y lanzara la excepcion

				throw new Exception("El alumno introducido no existe en este centro");

			} else {// Como el alumno est� sacamos la posicion en la que se encuentra

				if (alumnos.get(posicionAlumno).getNotas().size() == 0) {// Si al alumno no se le ha asignado ninguna
																			// calificacion sacar� una Excepcion

					throw new Exception("El alumno no tiene calificaciones asignadas");

				} else {// Si tiene faltas pasamos a mostrarlas

					for (int i = 0; i < alumnos.get(posicionAlumno).getNotas().size(); i++) {

						System.out.println("El alumno tiene un " + alumnos.get(posicionAlumno).getNotas().get(i).getNota() + " en " + alumnos.get(posicionAlumno).getNotas().get(i).getAsignatura());

					}

				}

			}

		}

	}

	// Autor: Antonio Garcia
	// Ponermos el dia completo como que ha faltado del alumno que elijamos
	public static void ponerFaltaDiaCompleto(ArrayList<Alumno> alumnos) throws Exception {

		// Variables
		int dia, mes, agno, posicion;
		boolean faltaAsignada = false;
		DiaClase diaClaseAux;
		Fecha fechaDia;

		// Entradas
		Scanner entrada = new Scanner(System.in);

		posicion = existeAlumno(alumnos);

		// Preguntamos si existe el alumno
		if (posicion != -1) {// Si existe pedimos los datos de la fecha para poner la falta

			System.out.println("dia");
			dia = entrada.nextInt();

			System.out.println("mes");
			mes = entrada.nextInt();

			System.out.println("a�o");
			agno = entrada.nextInt();

			fechaDia = new Fecha(dia, mes, agno);// Creacion del objeto con los datos introducidos

			// Primero vemos si el alumno tiene alguna falta o no
			if (alumnos.get(posicion).getFaltas().size() == 0) {// Si no tiene faltas se la ponemos

				diaClaseAux = new DiaClase(fechaDia);

				diaClaseAux.getHorario().faltaDiaEntero();// Ponemos la falta en ese dia

				alumnos.get(posicion).getFaltas().add(diaClaseAux);// La a�adimos

				faltaAsignada = true;

			} else {// Si tiene faltas, buscamos si tiene el mismo dia que la queremos poner

				for (int j = 0; j < alumnos.get(posicion).getFaltas().size(); j++) {

					if (alumnos.get(posicion).getFaltas().get(j).getDia().equals(fechaDia)) { // Si tiene ese mismo dia

						alumnos.get(posicion).getFaltas().remove(j);// Borramos esa falta

						diaClaseAux = new DiaClase(fechaDia);// Creamos el objeto con esa fecha

						diaClaseAux.getHorario().faltaDiaEntero();// Ponemos las faltas en todo el dia en esa fecha

						alumnos.get(posicion).getFaltas().add(diaClaseAux);// A�adimos ese objeto

						faltaAsignada = true;

					} else {// Tienes faltas pero de ese dia no

						diaClaseAux = new DiaClase(fechaDia);

						diaClaseAux.getHorario().faltaDiaEntero();// Ponemos el dia completo en ese dia

						alumnos.get(posicion).getFaltas().add(diaClaseAux);// Lo asignamos

						faltaAsignada = true;

					}

				}

			}

		} else {//Si no existe el alumno

			throw new Exception("No existe el alumno");

		}

	}

	// Autor: Antonio Garcia
	// Se le pone al alumno la falta en la sesion del dia que se especifica
	public static void ponerFaltasSesion(ArrayList<Alumno> alumnos, Fecha fechaDia) throws Exception {

		// Variables
		DiaClase diaClaseAux;
		int horaFalta = 0, posicionFaltas = 0, posicion;
		char[] sesiones;
		boolean faltaAsignada = false, encontrado = false;

		// Entradas
		Scanner entrada = new Scanner(System.in);

		// Comprobamos que la hora introducida esta entre 1 y 6

		while (horaFalta < 1 || horaFalta > 6) {
			System.out.println("Hora de la falta");
			horaFalta = entrada.nextInt();
			if (horaFalta < 1 || horaFalta > 6) {
				throw new Exception("Debe ser una hora en [1,6]");
			}

		}
		
		posicion = existeAlumno (alumnos);
		// Preguntamos si existe el alumno
		if (posicion != -1) {

			// Recorremos el Araylist de Alumno
			
				

					// A�adimos a faltas lo que contenga el arraylist list de falta de ese alumno
					ArrayList<DiaClase> faltas = alumnos.get(posicion).getFaltas();

					if (faltas.size() == 0) {// Comprobamos si el arraylist esta vacio

						diaClaseAux = new DiaClase(fechaDia);
						diaClaseAux.getHorario().faltaHora(horaFalta);
						alumnos.get(posicion).getFaltas().add(diaClaseAux);
						faltaAsignada = true;

					} else {// El alumno ya tiene faltas

						// Buscamos en su arraylist faltas si tiene alguna el mismo dia y cambiamos el
						// valor de la variable

						for (int j = 0; j < faltas.size(); j++) {

							if (alumnos.get(posicion).getFaltas().get(j).getDia().equals(fechaDia) == true) {// Si la tiene en
																										// el mismo dia

								posicionFaltas = j;
								encontrado = true;

							}

						}

						if (encontrado == true) {// Si la tiene en el mismo dia

							if (alumnos.get(posicion).getFaltas().get(posicionFaltas).getHorario().getSesiones()[horaFalta
									- 1] == 'F') {// Si la tiene la misma hora que la especificada

								throw new Exception("El alumno ya tiene falta en esa sesion");

							} else {// Si no la tiene en esa hora

								alumnos.get(posicion).getFaltas().get(posicionFaltas).getHorario().faltaHora(horaFalta);
								faltaAsignada = true;

							}

						} else {// Si no la tiene el mismo dia a�adimos la falta y el dia

							diaClaseAux = new DiaClase(fechaDia);
							diaClaseAux.getHorario().faltaHora(horaFalta);
							alumnos.get(posicion).getFaltas().add(diaClaseAux);
							faltaAsignada = true;
						}
					}

				
			

		} else {

			throw new Exception("No existe el alumno");

		}
	}

	// hecho por:juanra
	// pasar lista y poner falta aquel alunmo que no este.
	public static void pasarLista(ArrayList<Alumno> lista) throws Exception {
		// Declaramos variables
		Scanner entrada = new Scanner(System.in);
		int hora;
		int esta;
		int dia, mes, agno;
		int falta;
		Fecha fechaAux;
		DiaClase diaClaseAux;

		// Si no hay alumnos, lanzamos excepcion
		if (lista.size() == 0) {
			
			throw new Exception("No hay alumnos dados de alta");
			
		} else {// Si hay alumnos, as� que pasamos lista
			
			for (int i = 0; i < lista.size(); i++) {// recorrer� lista de alumnos.
				
				System.out.println("Alumno: " + lista.get(i).getApellidos() + " " + lista.get(i).getNombre());// obtendremos el alumno
					
				//Preguntamos si esta
				System.out.println("�Esta?");
				System.out.println("pulsa cualquier numero para SI o 0 para NO");
				esta = entrada.nextInt();
				
				if (esta == 0) {// si no esta pediremos el dia y la hora que ha faltado.

					// Pedir los datos de la fecha
					
					System.out.println("Dime el dia");
					dia = entrada.nextInt();
					
					System.out.println("Dime el mes");
					mes = entrada.nextInt();
					
					System.out.println("Dime el a�o");
					agno = entrada.nextInt();
					
					fechaAux = new Fecha(dia, mes, agno);//Asignamos los datos al objeto


					ponerFaltasSesion(lista, fechaAux);//Le asigna la falta a esa sesion 

				}

			}
		}
	}

	// hecho por:juanra.

	//Lista las faltas que tienen todos los alumnos

	public static void listarFaltas(ArrayList<Alumno> lista) throws Exception {
		Fecha fechaAux;
		if (lista.size() == 0) {//si no hay alunmos lazara excepcion.
			throw new Exception("No hay alumnos dados de alta");
		} else {
			for (int i = 0; i < lista.size(); i++) {// recorrer� lista de alumnos.

				
				System.out.println("Alumno: " + lista.get(i).getApellidos() + " " + lista.get(i).getNombre());//Muestra el alumno
				
				for (int j = 0; j < lista.get(i).getFaltas().size(); j++) {//Recorre el arraylist de faltas
					
					fechaAux = lista.get(i).getFaltas().get(j).getDia();//Fecha de las faltas
					
					System.out.println("\nDia: " + fechaAux.getDia() + "/" + fechaAux.getMes() + "/" + fechaAux.getAgno());//Muestra la fecha
					
					lista.get(i).getFaltas().get(j).getHorario().imprimeHora();//Muestra las faltas de esas sesiones

				}
			}
		}

	}

	public static void main(String[] args) throws Exception {

		// Variables
		int opcionMenu;
		boolean controlaMenu = false;

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		boolean repetir = false;

		// Menu
		while (controlaMenu == false) {// Variable que controla que el menu se muestre y se repita

			Scanner teclado = new Scanner(System.in);

			muestraMenu();// Muestra las opciones

			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt(); // Opcion elegida del menu
			teclado.nextLine();

			switch (opcionMenu) {

			// M�todo dar de alta alumno (Daniel Moreno)
			case 1:

				// Variables
				boolean repetir1 = true;
				int opcion1;

				// Bucle para repetir la opci�n de dar de alta si se desea
				while (repetir1 == true) {
					try {
						PracticaGrupoMain.altaAlumno(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					repetir1 = repetimos();
				}

				break;

			// M�todo dar de baja alumno (Daniel Moreno)
			case 2:

				// Variables
				boolean repetir2 = true;
				int opcion2;

				// Bucle para repetir la opci�n de dar de alta si se desea
				while (repetir2 == true) {

					try {
						PracticaGrupoMain.bajaAlumno(alumnos);

					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					repetir2 = repetimos();
				}

				break;

			// Listar los alumnos
			case 3:

				try {
					listarAlumnos(alumnos);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				break;

			// Modificar alumnos
			case 4:

				repetir = true;
				while (repetir) {
					try {
						modificarAlumno(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					repetir = repetimos();
				}

				break;

			// Matricular alumnos
			case 5:
				repetir = true;
				while (repetir) {
					try {
						matricularAlumno(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					repetir = repetimos();
				}
				break;

			case 6:
				boolean repetir6 = true;
				while (repetir6 == true) {
					try {
						PracticaGrupoMain.darDeBaja(alumnos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					repetir6 = repetimos();
				}

				break;

			case 7:
				boolean repetir7 = true;
				while (repetir7 == true) {
					try {
						PracticaGrupoMain.ponerCalificacion(alumnos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					repetir7 = repetimos();
				}
				break;

			// Mostrar las calificaciones
			case 8:
				try {
					muestraCalificaciones(alumnos);
				} catch (Exception ex) {

					System.out.println(ex.getMessage());
				}
				break;

			// Poner falta en un dia completo
			case 9:
				try {

					ponerFaltaDiaCompleto(alumnos);

				} catch (Exception ex) {

					System.out.print(ex.getMessage());

				}

				break;

			// Poner una falta en una sesion
			case 10:
				
				//Variables
				int dia, mes, agno, posicion;
				Fecha fecha = null;
				Alumno alum;
				
				//Entradas
				Scanner entrada = new Scanner(System.in);

				//Introducimos la fecha
				System.out.println("dia");
				dia = entrada.nextInt();

				System.out.println("mes");
				mes = entrada.nextInt();

				System.out.println("a�o");
				agno = entrada.nextInt();

				//Comprobamos que la fecha es correcta
				try {
					fecha = new Fecha(dia, mes, agno);
				} catch (Exception ex) {

					System.out.println(ex.getMessage());
				}

				//Comprobamos que el metodo funciona correctamente
				try {

					ponerFaltasSesion(alumnos, fecha);

				} catch (Exception ex) {

					System.out.println(ex.getMessage());

				}


				break;

			// Pasar lista.
			case 11:
				// Llamamos al metodo

				try {
					pasarLista(alumnos);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				break;

			// Listar faltas.
			case 12:
				try {
					listarFaltas(alumnos);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				break;

			// Salir
			case 13:

				controlaMenu = true;
				
				System.out.println("Programa cerrado.");

				break;

			// Opcion por defecto
			default:

				System.out.println("No se ha introducido ninguna de las opciones del menu");
				break;

			}

		}

	}

}
