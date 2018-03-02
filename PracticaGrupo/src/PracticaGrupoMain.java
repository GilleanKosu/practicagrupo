import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

public class PracticaGrupoMain {

	// Muestra el menu
	public static void muestraMenu() {
		System.out.println(
				"\n 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificación trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
	}

	
	// Método hecho por: Daniel Moreno Navarro
	public static void ordenarAlumnos(ArrayList<Alumno> alumnos, Alumno NuevoAl) {

		boolean parar = false;
		int posicion = 0;

		//if (alumnos.size() == 0) {
		if (alumnos.isEmpty()) {	
			alumnos.add(NuevoAl);
		} else {
			for (int i = 0; i < alumnos.size() && parar == false; i++) {
				
				posicion = i;
				
				if (NuevoAl.getApellidos().compareToIgnoreCase(alumnos.get(i).getApellidos()) < 0) {
					
					parar = true;
					
					/* Para Pruebas
					System.out.println("Numero: " + NuevoAl.getApellidos().compareToIgnoreCase(alumnos.get(i).getApellidos()));
					System.out.println("posicion: " + i);*/
					
				}
			}
			
			if (parar) {
				alumnos.add(posicion, NuevoAl);
			} else {
				alumnos.add(posicion + 1, NuevoAl);
			}

		}
	}

	// Método hecho por: Daniel Moreno Navarro
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

		// Teléfomo
		System.out.println("Teléfono del alumno:");
		nuevoAlumno.setTelefono(entrada.nextLine());

		// Email
		System.out.println("Email del alumno:");
		nuevoAlumno.setEmail(entrada.nextLine());

		// Comprobamos que el alumno no esté ya en el ArrayList. Si está, devolvemos la
		// excepción
		// y si no está, lo añadimos, llamando al método ordenarAlumnos para que se vayan
		//incluyendo en el arrayList por orden alfabético.
		if (alumnos.contains(nuevoAlumno)) {
			throw new Exception("Error. El alumno ya existe.\n");
		} else {
			ordenarAlumnos(alumnos, nuevoAlumno);
			// alumnos.add(nuevoAlumno);
			System.out.println("Alumno añadido.\n");
		}
	}

	// Método hecho por: Daniel Moreno Navarro
	public static void bajaAlumno(ArrayList<Alumno> alumnos) throws Exception {

		Scanner entrada = new Scanner(System.in);

		// Variables
		String numero;
		boolean contiene = false;

		// Primero mostramos la lista con los alumnos que tenemos
		listarAlumnos(alumnos);

		// Comprobamos que no esté vacío el ArrayList, si está vacío, no seguimos con el
		// proceso
		if (alumnos.isEmpty() == false) {

			System.out.println("DNI del alumno que desea dar de baja:");// Guardamos el DNI en la variable "numero"
			numero = entrada.nextLine();

			// Con un buble for recorreremos el ArrayList hasta que el dni indicado coincida
			// con algún dni dentro de la lista
			for (int i = 0; i < alumnos.size() && contiene == false; i++) {

				if (alumnos.get(i).getDni().equals(numero)) {

					contiene = true;// de haber encontrado el dni indicado, cambiamos contiene a "true" para que no
									// continúe el bucle

					alumnos.remove(i);// Eliminamos el alumno en la posición "i"

					System.out.println("Alumno eliminado con éxito.");
				}
			}

			// Si contiene sigue siendo "false", significa que el dni no se ha encontrado en
			// el ArrayList, así que lanzamos una excepción
			if (contiene == false) {
				throw new Exception("El DNI introducido no está en la lista.");
			}
		}
	}

	// Compara si existe un elemento en concreto de tipo Fecha en el arraylist
	// introducido
	public static boolean existeFecha(Fecha fecha, ArrayList<Fecha> arrayFechas) {

		if (arrayFechas.contains(fecha)) {
			return true;
		} else {
			return false;
		}
	}

	// Compara si existe un elemento en concreto de tipo Horario en el arraylist
	// introducido(Puede que no sea necesario)
	public static boolean existeHorario(Horario horario, ArrayList<Horario> arrayHorario) {
		if (arrayHorario.contains(horario)) {
			return true;
		} else {
			return false;
		}
	}

	// Comprara si existe un elemento en concreto de tipo DiaClase en el arraylist
	// introducido
	public static boolean existeDiaClase(DiaClase dia, ArrayList<DiaClase> arrayDiasClase) {

		if (arrayDiasClase.contains(dia)) {
			return true;
		} else {
			return false;
		}
	}

	// Compara si existe un elemento en concreto de tipo Calificacion en el
	// arraylist
	public static boolean existeCalificacion(Calificacion calificacion, ArrayList<Calificacion> arrayCalificacion) {

		if (arrayCalificacion.contains(calificacion)) {
			return true;
		} else {
			return false;
		}
	}

	
	//Autor: Puri Amoros (Antonio solo ha modificado el mensaje del DNI)
	//Comprobar si existe el alumno
	public static int existeAlumno (ArrayList<Alumno> arrayAlumnos) {
			
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduzca el dni:");
		String dni = entrada.nextLine();
		
		Alumno aBuscar = new Alumno(dni);
		
		int posicion = arrayAlumnos.indexOf(aBuscar);
		
		return posicion;
		
	}

	// Autor listarAlumnos: Daniel Garrido Castro
	// Ver si tenemos alumnos en el arraylist y, si no está vacío,
	// mostraremos los alumnos (datos básicos: dni, apellidos, nombre)
	public static void listarAlumnos(ArrayList<Alumno> alumnos) throws Exception {
		if (alumnos.size() > 0) {// En caso de que no esté vacío, recorremos el ArrayList y mostramos algunos
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
	// indicado que sí,
	// false en caso contrario
	public static boolean repetimos() {
		// Declaración de variables
		Scanner entrada = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("¿Desea realizar de nuevo la operación?");
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
	// Muestra la lista de alumnos, pide cuál se quiere modificar
	public static void modificarAlumno(ArrayList<Alumno> alumnos) throws Exception {
		// Declaración de variables
		Scanner entrada = new Scanner(System.in);
		String dni = new String();// donde guardar el dni del alumno a modificar
		String aux = new String();// usada para modificar datos del alumno
		int opcion;
		boolean encontrado = false;

		// Muestra la lista de alumnos
		listarAlumnos(alumnos);

		// Pide cuál se quiere modificar
		System.out.println("Introd. el dni del alumno a modificar: ");
		dni = entrada.nextLine();

		// Recorro la lista de alumnos para ver si existe el dni
		for (int i = 0; i < alumnos.size() && !encontrado; i++) {

			if (alumnos.get(i).getDni().equals(dni)) {// Si el dni está en el arraylist
				encontrado = true;
				System.out.println("\n¿Que dato quiere modificar del alumno " + dni + "?");
				System.out.println("1. DNI");
				System.out.println("2. Nombre");
				System.out.println("3. Apellidos");
				System.out.println("4. Telefono");
				System.out.println("5. email");
				System.out.println("6. Salir");
				opcion = entrada.nextInt();
				entrada.nextLine();// Limpiar buffer

				switch (opcion) {
				case 1:
					System.out.println("Antiguo dni: " + dni + " ¿Cual es el nuevo DNI?");
					aux = entrada.nextLine();
					if (alumnos.contains(new Alumno(aux)))
						throw new Exception("ERROR! El DNI introducido ya pertenece a otro alumno");
					else {
						alumnos.get(i).setDni(aux);
						System.out.println("El dni del alumno ahora es: " + alumnos.get(i).getDni());
					}
					break;
				case 2:
					System.out.println("Antiguo nombre: " + alumnos.get(i).getNombre() + " ¿Cual es el nuevo nombre?");
					aux = entrada.nextLine();
					alumnos.get(i).setNombre(aux);
					System.out.println("El alumno ahora se llama: " + alumnos.get(i).getNombre());
					break;
				case 3:
					System.out.println(
							"Antiguo apellido: " + alumnos.get(i).getApellidos() + " ¿Cual es el nuevo apellido?");
					aux = entrada.nextLine();
					alumnos.get(i).setApellidos(aux);
					System.out.println("El alumno ahora se apellida: " + alumnos.get(i).getApellidos());
					break;
				case 4:
					System.out.println("Antiguo tlf: " + alumnos.get(i).getTelefono() + " ¿Cual es el nuevo telefono?");
					aux = entrada.nextLine();
					alumnos.get(i).setTelefono(aux);
					System.out.println("El tlf del alumno ahora es: " + alumnos.get(i).getTelefono());
					break;
				case 5:
					System.out.println("Antiguo email: " + alumnos.get(i).getEmail() + " ¿Cual es el nuevo email?");
					aux = entrada.nextLine();
					alumnos.get(i).setEmail(aux);
					System.out.println("El email del alumno ahora es: " + alumnos.get(i).getEmail());
					break;
				case 6:
					System.out.println("Ha elegido salir");
					break;
				default:
					System.out.println("Opción incorrecta. Pruebe con una en [1,6]");
				}
			}
		}
		if (!encontrado)
			throw new Exception("No existe el alumno indicado");
	}

	// Autor matricularAlumnos: Daniel Garrido Castro
	// Comprueba que existe el Alumno y que no está matriculado de la asignatura.
	// También comprueba que esa asignatura no esté metida en el arraylist de notas
	// (no lo vamos a matricular de algo donde ya está matriculado).
	// En ese caso, lo matricula
	public static void matricularAlumno(ArrayList<Alumno> alumnos) throws Exception {
		// Declaración de variables

		Scanner entrada = new Scanner(System.in);
		String dni = new String();
		Calificacion calificacionAux;
		ArrayList<Calificacion> notas = new ArrayList<Calificacion>();
		String[] asignaturas = { "FOL", "Sistemas", "Entornos de desarrollo", "Programacion", "Lenguajes de marcas",
				"Bases de datos" };
		int opcion;

		if (alumnos.size() == 0)
			throw new Exception("Error!. Aun no hay alumnos en el listado");
		else {
			// Pide cuál se quiere matricular
			System.out.println("Introd. el dni del alumno a matricular: ");
			dni = entrada.nextLine();

			if (!alumnos.contains(new Alumno(dni))) {// El alumno no está en el conjunto
				throw new Exception("Error!. No existe el alumno " + dni);
			} else {// El alumno sí está, pedimos la asignatura en que lo vamos a matricular
				do {
					System.out.println("¿De qué asignatura se va a matricular?");
					for (int i = 0; i < asignaturas.length; i++) {
						System.out.println((i) + " " + asignaturas[i]);
					}
					opcion = entrada.nextInt();
					entrada.nextLine();// Limpiar buffer

					if (opcion < 0 || opcion > 5)
						System.out.println("Debe elegir un valor en [0,5]. Pruebe otra vez");
				} while (opcion < 0 || opcion > 5);
							
				//Si ya está matriculado de esa asignatura, lanzo excepción, si no, lo matriculo
				if( alumnos.get(alumnos.indexOf(new Alumno(dni))).getNotas().contains(asignaturas[opcion]) ) {
					throw new Exception("Ya matriculado");
				}
				//lo matriculo
				calificacionAux = new Calificacion(asignaturas[opcion]);
				calificacionAux.setNota("NE");
				alumnos.get(alumnos.indexOf(new Alumno(dni))).getNotas().add(calificacionAux);
//				alumnos.get(i).getNotas().add(calificacionAux);
			}
		}
	}

	// Dar de baja - Danut Nelu Moldovan
	public static void darDeBaja(ArrayList<Alumno> alumnos) throws Exception {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca el DNI del alumno.");// Se pide el DNI del alumno
		String dni = teclado.nextLine();
		// Se declaran variables
		int posicion = 0;
		boolean matriculado = false;
		boolean existe = false;
		// Se comprueba si el alumno está en el arraylist
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(dni)) {
				existe = true;
				posicion = i;
			}
		}
		// Se imprimen las asignaturas en las que está matriculado si el alumno existe y
		// está matriculado en alguna asignatura
		if (existe == true && alumnos.get(posicion).getNotas().size() != 0) {
			System.out.println("Asignaturas en las que está matriculado el alumno:");
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
					System.out.println("El alumno ya no está matriculado en " + asignatura + ".");
					matriculado = true;
				}
			}
			if (matriculado == false) {
				System.out.println("El alumno no estaba matriculado en " + asignatura + ".");
			}
		} else {
			if (existe == false) {
				throw new Exception("Alumno no encontrado.");
			} else {
				if (alumnos.get(posicion).getNotas().size() == 0) {
					throw new Exception("El alumno no está matriculado en ninguna asignatura.");
				}
			}
		}

	}

	// Calificacion trimestral - Danut Nelu Moldovan
	public static void ponerCalificacion(ArrayList<Alumno> alumnos) throws Exception {
		Scanner teclado = new Scanner(System.in);
		// Se pide el DNI del alumno
		System.out.println("Introduzca el DNI del alumno.");
		String dni = teclado.nextLine();
		// Se comprueba si existe el alumno y se guarda su posición
		int posicion = 0;
		boolean existe = false;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(dni)) {
				existe = true;
				posicion = i;
			}
		}
		if (existe == true) {
			// Se compueba si el alumno está matriculado en alguna asignatura.
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
				throw new Exception("El alumno no está matriculado en ninguna asignatura.");
			}

		} else {
			throw new Exception("Alumno no encontrado");
		}
		
	}

	// Autor: Antonio Garcia
	// 8. Mostrar las calificaciones

	public static void muestraCalificaciones(ArrayList<Alumno> alumnos) throws Exception {
		
		//Variables
		String dniAlumno;
		int posicionAlumno;
		
		//Entradas
		Scanner entrada = new Scanner(System.in);
		
		//Procesos
		
		if (alumnos.size() == 0) {//Comprobamos si el array esta vacio
			
			throw new Exception("No hay alumnos de los que mostrar las calificaciones");
			
		} else {//Si no esta vacio preguntaremos el dni del alumno para mostrar sus datos
			
			System.out.println("Introduzca el dni del alumno");
			dniAlumno = entrada.nextLine();

			if (existeAlumno(alumnos, dniAlumno) == -1) {//Si el alumno no esta devolvera -1 y lanzara la excepcion
				
				throw new Exception("El alumno introducido no existe en este centro");
				
			} else {//Como el alumno está sacamos la posicion en la que se encuentra
				
				posicionAlumno = existeAlumno(alumnos, dniAlumno);
				
				if (alumnos.get(posicionAlumno).getNotas().size()==0) {//Si al alumno no se le ha asignado ninguna calificacion sacará una Excepcion
					
					throw new Exception ("El alumno no tiene calificaciones asignadas");
					
				} else {//Si tiene faltas pasamos a mostrarlas
					
					for (int i = 0; i < alumnos.get(posicionAlumno).getNotas().size(); i++) {

						System.out.println(alumnos.get(posicionAlumno).getNotas().get(i).getNota());
						
					}
					
				}

				

			}

		}

	}

	// Autor: Antonio Garcia
	// 9. Poner el dia completo como que ha faltado
	public static void ponerFaltaDiaCompleto(ArrayList<Alumno> alumnos) throws Exception {

		// Variables
		String dni;
		int dia, mes, agno;
		boolean faltaAsignada = false;
		DiaClase diaClaseAux;
		Fecha fechaDia;

		// Entradas
		Scanner entrada = new Scanner(System.in);

		System.out.println("Dni");
		dni = entrada.nextLine();

		// Preguntamos si existe el alumno
		if (alumnos.contains(new Alumno(dni))) {// Si existe pedimos los datos de la fecha para poner la falta

			System.out.println("dia");
			dia = entrada.nextInt();

			System.out.println("mes");
			mes = entrada.nextInt();

			System.out.println("año");
			agno = entrada.nextInt();

			fechaDia = new Fecha(dia, mes, agno);// Creacion del objeto con los datos introducidos

			// Recorremos el Araylist de Alumno
			for (int i = 0; i < alumnos.size() && faltaAsignada == false; i++) {

				if (alumnos.get(i).getDni().equals(dni)) {

					// Primero vemos si el alumno tiene alguna falta o no
					if (alumnos.get(i).getFaltas().size() == 0) {//Si no tiene faltas se la ponemos
						
						diaClaseAux = new DiaClase(fechaDia);
						
						diaClaseAux.getHorario().faltaDiaEntero();//Ponemos la falta en ese dia
						
						alumnos.get(i).getFaltas().add(diaClaseAux);//La añadimos
						
						faltaAsignada = true;

					} else {// Si tiene faltas, buscamos si tiene el mismo dia que la queremos poner

						for (int j = 0; j < alumnos.get(i).getFaltas().size(); j++) {

							if (alumnos.get(i).getFaltas().get(j).getDia().equals(fechaDia)) { // Si tiene ese mismo dia

								alumnos.get(i).getFaltas().remove(j);//Borramos esa falta
								
								diaClaseAux = new DiaClase(fechaDia);//Creamos el objeto con esa fecha
								
								diaClaseAux.getHorario().faltaDiaEntero();//Ponemos las faltas en todo el dia en esa fecha
								
								alumnos.get(i).getFaltas().add(diaClaseAux);//Añadimos ese objeto
								
								faltaAsignada = true;

							} else {// Tienes faltas pero de ese dia no

								diaClaseAux = new DiaClase(fechaDia);
								
								diaClaseAux.getHorario().faltaDiaEntero();//Ponemos el dia completo en ese dia
								
								alumnos.get(i).getFaltas().add(diaClaseAux);//Lo asignamos
								
								faltaAsignada = true;

							}

						}

					}

				}

			}

		} else {
			throw new Exception("No existe el alumno");
		}

	}

	// Autor: Antonio Garcia
	// 10. Poner la falta de la hora en concreto
	public static void ponerFaltasSesion(ArrayList<Alumno> alumnos, String dni, Fecha fechaDia) throws Exception {

		// Variables
		DiaClase diaClaseAux;
		int horaFalta = 0, posicionFaltas = 0;
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

		// Preguntamos si existe el alumno
		if (alumnos.contains(new Alumno(dni))) {

			// Recorremos el Araylist de Alumno
			for (int i = 0; (i < alumnos.size()) && (faltaAsignada == false); i++) {
				if (alumnos.get(i).getDni().equals(dni)) {

					// Añadimos a faltas lo que contenga el arraylist list de falta de ese alumno
					ArrayList<DiaClase> faltas = alumnos.get(i).getFaltas();

					if (faltas.size() == 0) {// Comprobamos si el arraylist esta vacio

						diaClaseAux = new DiaClase(fechaDia);
						diaClaseAux.getHorario().faltaHora(horaFalta);
						alumnos.get(i).getFaltas().add(diaClaseAux);
						faltaAsignada = true;

					} else {// El alumno ya tiene faltas

						// Buscamos en su arraylist faltas si tiene alguna el mismo dia y cambiamos el
						// valor de la variable

						for (int j = 0; j < faltas.size(); j++) {

							if (alumnos.get(i).getFaltas().get(j).getDia().equals(fechaDia) == true) {// Si la tiene en
																										// el mismo dia

								posicionFaltas = j;
								encontrado = true;

							}

						}

						if (encontrado == true) {// Si la tiene en el mismo dia

							if (alumnos.get(i).getFaltas().get(posicionFaltas).getHorario().getSesiones()[horaFalta
									- 1] == 'F') {// Si la tiene la misma hora que la especificada

								throw new Exception("El alumno ya tiene falta en esa sesion");

							} else {// Si no la tiene en esa hora

								alumnos.get(i).getFaltas().get(posicionFaltas).getHorario().faltaHora(horaFalta);
								faltaAsignada = true;

							}

						} else {// Si no la tiene el mismo dia añadimos la falta y el dia

							diaClaseAux = new DiaClase(fechaDia);
							diaClaseAux.getHorario().faltaHora(horaFalta);
							alumnos.get(i).getFaltas().add(diaClaseAux);
							faltaAsignada = true;
						}
					}

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
		} else {// Si hay alumnos, así que pasamos lista
			for (int i = 0; i < lista.size(); i++) {// recorrerá lista de alumnos.
				System.out.println("Alumno: " + lista.get(i).getApellidos() + " " + lista.get(i).getNombre());// obtendremos
																												// el
																												// alumno.
				System.out.println("¿Esta?");
				System.out.println("pulsa cualquier tecla para si o 0 para no");
				esta = entrada.nextInt();
				if (esta == 0) {// si no esta pediremos el dia y la hora que ha faltado.

					// Pedir fecha
					System.out.println("Dime el dia");
					dia = entrada.nextInt();
					System.out.println("Dime el mes");
					mes = entrada.nextInt();
					System.out.println("Dime el año");
					agno = entrada.nextInt();
					fechaAux = new Fecha(dia, mes, agno);

					ponerFaltasSesion(lista, lista.get(i).getDni(), fechaAux);
				}

			}
		}
	}

	// hecho por:juanra.
	public static void listarFaltas(ArrayList<Alumno> lista) throws Exception {
		Fecha fechaAux;
		if (lista.size() == 0) {
			throw new Exception("No hay alumnos dados de alta");
		} else {
			for (int i = 0; i < lista.size(); i++) {// recorrerá lista de alumnos.
				// ArrayList<DiaClase> faltas = lista.get(i).getFaltas();//obtenemos lista
				// faltas
				System.out.println("Alumno: " + lista.get(i).getApellidos() + " " + lista.get(i).getNombre());
				for (int j = 0; j < lista.get(i).getFaltas().size(); j++) {
					fechaAux = lista.get(i).getFaltas().get(j).getDia();
					System.out.println(
							"\nDia: " + fechaAux.getDia() + "/" + fechaAux.getMes() + "/" + fechaAux.getAgno());
					lista.get(i).getFaltas().get(j).getHorario().imprimeHora();
				}
			}
		}

	}

	public static void main(String[] args) {

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

			// Método dar de alta alumno (Daniel Moreno)
			case 1:

				// Variables
				boolean repetir1 = true;
				int opcion1;

				// Bucle para repetir la opción de dar de alta si se desea
				while (repetir1 == true) {
					try {
						PracticaGrupoMain.altaAlumno(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					repetir1 = repetimos();
				}

				break;

			// Método dar de baja alumno (Daniel Moreno)
			case 2:

				// Variables
				boolean repetir2 = true;
				int opcion2;

				// Bucle para repetir la opción de dar de alta si se desea
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
				
			//Mostrar las calificaciones
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

				String dni;
				int dia, mes, agno;
				Fecha fecha = null;
				Alumno alum;
				Scanner entrada = new Scanner(System.in);

				System.out.println("Dni");
				dni = entrada.nextLine();

				alum = new Alumno(dni);

				if (alumnos.contains(alum)) {

					System.out.println("dia");
					dia = entrada.nextInt();

					System.out.println("mes");
					mes = entrada.nextInt();

					System.out.println("año");
					agno = entrada.nextInt();

					try {
						fecha = new Fecha(dia, mes, agno);
					} catch (Exception ex) {

						System.out.println(ex.getMessage());
					}

					try {

						ponerFaltasSesion(alumnos, dni, fecha);

					} catch (Exception ex) {

						System.out.println(ex.getMessage());

					}

				} else {

					System.out.println("No existe ese alumno");

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
