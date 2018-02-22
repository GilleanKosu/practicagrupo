import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

public class PracticaGrupoMain {
	
	//Muestra el menu
	public static void muestraMenu () {
		System.out.println("\n 1. Dar de alta alumno \n 2. Dar de baja alumnos \n 3. Listar los alumnos \n 4. Modificar los alumnos \n 5. Matricular los alumnos \n 6. Dar de baja de una asignatura \n 7. Introducir calificaci�n trimestral \n 8. Listar calificaciones de alumnos \n 9. Poner una falta (dia completo) \n 10. Poner una falta (en una sesion) \n 11. Pasar lista \n 12. Listar faltas \n 13. Salir \n");
	}
	
	
	
	public static void ordenarAlumnos(ArrayList<Alumno> alumnos, Alumno al) {
		
		boolean parar = false;
		int posicion=0;
		
		if(alumnos.size()==0) {
			alumnos.add(al);
		}else {
			for(int i = 0; i < alumnos.size() && parar == false; i++) {
					posicion=i;
				if (al.getApellidos().compareToIgnoreCase(alumnos.get(i).getApellidos())<0) {
					parar = true;
				}
			}
			if(parar) {
				alumnos.add(posicion,al);
			}else {
				alumnos.add(posicion+1,al);
			}
				
		}
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
			throw new Exception ("Error. El alumno ya existe.\n");
		}else {
			ordenarAlumnos(alumnos, nuevoAlumno);
		//alumnos.add(nuevoAlumno);
		System.out.println("Alumno a�adido.\n");
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
	public static void listarAlumnos(ArrayList<Alumno> alumnos) throws Exception{
		if(alumnos.size()>0) {//En caso de que no est� vac�o, recorremos el ArrayList y mostramos algunos datos
			System.out.println("\nListado de alumnos: ");
			System.out.println("\nHay "+alumnos.size()+"alumnos: ");
			for(int i=0; i<alumnos.size(); i++) {
				System.out.println(alumnos.get(i).getDni()+" "+alumnos.get(i).getApellidos()+", "+alumnos.get(i).getNombre());
			}
		}
		else
			throw new Exception("Sin alumnos dados de alta.");
	}
	
	
	
	//Pregunta si se quiere repetir la operacion y devuelve true si el usuario ha indicado que s�,
	//false en caso contrario
	public static boolean repetimos() {
		//Declaraci�n de variables
		Scanner entrada = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("�Desea realizar de nuevo la operaci�n?");
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
	//Muestra la lista de alumnos, pide cu�l se quiere modificar
	public static void modificarAlumno(ArrayList<Alumno> alumnos) throws Exception {
		//Declaraci�n de variables
		Scanner entrada = new Scanner(System.in);
		String dni = new String();//donde guardar el dni del alumno a modificar
		String aux = new String();//usada para modificar datos del alumno
		int opcion;
		boolean encontrado=false;
		
		//Muestra la lista de alumnos
		listarAlumnos(alumnos);
		
		//Pide cu�l se quiere modificar
		System.out.println("Introd. el dni del alumno a modificar: ");
		dni=entrada.nextLine();
		
		//Recorro la lista de alumnos para ver si existe el dni
		for(int i=0; i<alumnos.size() && !encontrado; i++) {
		
			if(alumnos.get(i).getDni().equals(dni)) {//Si el dni est� en el arraylist
				encontrado=true;
				System.out.println("\n�Que dato quiere modificar del alumno "+dni+"?");
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
						System.out.println("Antiguo dni: "+dni+" �Cual es el nuevo DNI?");
						aux=entrada.nextLine();
						if(alumnos.contains(new Alumno(aux)))
							throw new Exception("ERROR! El DNI introducido ya pertenece a otro alumno");
						else {
							alumnos.get(i).setDni(aux);
							System.out.println("El dni del alumno ahora es: "+alumnos.get(i).getDni());
						}
						break;
					case 2:
						System.out.println("Antiguo nombre: "+alumnos.get(i).getNombre()+" �Cual es el nuevo nombre?");
						aux=entrada.nextLine();
						alumnos.get(i).setNombre(aux);
						System.out.println("El alumno ahora se llama: "+alumnos.get(i).getNombre());
						break;
					case 3:
						System.out.println("Antiguo apellido: "+alumnos.get(i).getApellidos()+" �Cual es el nuevo apellido?");
						aux=entrada.nextLine();
						alumnos.get(i).setApellidos(aux);
						System.out.println("El alumno ahora se apellida: "+alumnos.get(i).getApellidos());
						break;
					case 4:
						System.out.println("Antiguo tlf: "+alumnos.get(i).getTelefono()+" �Cual es el nuevo telefono?");
						aux=entrada.nextLine();
						alumnos.get(i).setTelefono(aux);
						System.out.println("El tlf del alumno ahora es: "+alumnos.get(i).getTelefono());
						break;
					case 5:
						System.out.println("Antiguo email: "+alumnos.get(i).getEmail()+" �Cual es el nuevo email?");
						aux=entrada.nextLine();
						alumnos.get(i).setEmail(aux);
						System.out.println("El email del alumno ahora es: "+alumnos.get(i).getEmail());
						break;
					case 6:
						System.out.println("Ha elegido salir");
						break;
					default:
						System.out.println("Opci�n incorrecta. Pruebe con una en [1,6]");
				}
			}
		}
		if(!encontrado)
			throw new Exception("No existe el alumno indicado");
	}

	//Autor matricularAlumnos: Daniel Garrido Castro
	//Comprueba que existe el Alumno y que no est� matriculado de la asignatura.
	//Tambi�n comprueba que esa asignatura no est� metida en el arraylist de notas (no lo vamos a matricular de algo donde ya est� matriculado).
	//En ese caso, lo matricula
	public static void matricularAlumno(ArrayList<Alumno> alumnos) throws Exception{
		//Declaraci�n de variables
			
		Scanner entrada = new Scanner(System.in);
		String dni = new String();
		Calificacion calificacionAux;
		ArrayList<Calificacion> notas = new ArrayList<Calificacion>();
		String[] asignaturas= {"FOL", "Sistemas", "Entornos de desarrollo", "Programacion", "Lenguajes de marcas", "Bases de datos"};
		int opcion;
		
		if(alumnos.size()==0)
			throw new Exception("Error!. Aun no hay alumnos en el listado");
		else {
			//Pide cu�l se quiere matricular
			System.out.println("Introd. el dni del alumno a matricular: ");
			dni=entrada.nextLine();
			
			if(!alumnos.contains(new Alumno(dni))) {//El alumno no est� en el conjunto
				throw new Exception("Error!. No existe el alumno "+dni);
			}
			else {//El alumno s� est�, pedimos la asignatura en que lo vamos a matricular
				do {
					System.out.println("�De qu� asignatura se va a matricular?");
					for(int i=0;i<asignaturas.length;i++) {
						System.out.println((i)+" "+asignaturas[i]);
					}
					opcion=entrada.nextInt();
					entrada.nextLine();//Limpiar buffer
					
					if(opcion<0 || opcion>5)
						System.out.println("Debe elegir un valor en [0,5]. Pruebe otra vez");
				}while(opcion<0 || opcion>5);
				
				//Si ya est� matriculado de esa asignatura, lanzamos excepci�n
				for(int i=0; i<alumnos.size();i++) {
					if(alumnos.get(i).getDni().equals(dni))//selecciono el alumno
						notas=alumnos.get(i).getNotas();//tengo las notas, ahora he de mirar si la asignatura ya est� entre las del alumno
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
	//8. Mostrar las calificaciones
	
	public static void muestraCalificaciones (ArrayList <Alumno> alumnos) throws Exception {
		
		String dniAlumno;
		int posicionAlumno;
		
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Introduzca el dni del alumno");
		dniAlumno=entrada.nextLine();
		
		
		if (alumnos.contains(dniAlumno) == false) {
			System.out.println("El alumno introducido no existe en este centro");
		}
		
		posicionAlumno=alumnos.indexOf(dniAlumno);
		
		for (int i = 0; i < alumnos.get(posicionAlumno).getNotas().size(); i++)  {
			
			System.out.println(alumnos.get(posicionAlumno).getNotas().get(i).getNota());
		}
	}
	
	//Autor: Antonio Garcia
	//9. Poner el dia completo como que ha faltado
	public static void ponerFaltaDiaCompleto (ArrayList <Alumno> alumnos) throws Exception {
		
		//Variables
		String dni;
		int dia, mes, agno;
		DiaClase diaClaseAux;
		boolean faltaAsignada=false;
		
		//Entradas
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Dni");
		dni=entrada.nextLine();
		
		System.out.println("dia");
		dia=entrada.nextInt();
		
		System.out.println("mes");
		mes=entrada.nextInt();
		
		System.out.println("a�o");
		agno=entrada.nextInt();
		
		Fecha fechaDia = new Fecha (dia, mes, agno);//Creacion del objeto con los datos introducidos
		
		
		//Preguntamos si existe el alumno
		if (alumnos.contains(new Alumno(dni))) {
			
			//Recorremos el Araylist de Alumno
			for (int i = 0; i < alumnos.size() && faltaAsignada==false; i++) {
				
				System.out.print(alumnos.get(i).getDni().equals(dni));
				
				if(alumnos.get(i).getDni().equals(dni)) {
					
					//Primero vemos si el alumno tiene alguna falta o no
					if(alumnos.get(i).getFaltas().size()==0) {
						diaClaseAux = new DiaClase(fechaDia);
						diaClaseAux.getHorario().faltaDiaEntero();
						alumnos.get(i).getFaltas().add(diaClaseAux);
						faltaAsignada=true;
						
					} else {//Si tiene faltas, buscamos si tiene el mismo dia que la queremos poner
						
							for (int j = 0; j <alumnos.get(i).getFaltas().size(); j ++) {
								
								if (alumnos.get(i).getFaltas().get(j).getDia().equals(fechaDia)) { //Si tiene el mismo dia se borra y se sustituye
									alumnos.get(i).getFaltas().remove(j);
									diaClaseAux = new DiaClase(fechaDia);
									diaClaseAux.getHorario().faltaDiaEntero();
									alumnos.get(i).getFaltas().add(diaClaseAux);
									faltaAsignada=true;
									
								} else {//Tienes faltas pero de ese dia no
									
									diaClaseAux = new DiaClase(fechaDia);
									diaClaseAux.getHorario().faltaDiaEntero();
									alumnos.get(i).getFaltas().add(diaClaseAux);
									faltaAsignada=true;
									
								}
									
							}
						
						
					}

				}
				
			}
			
		} else {
			throw new Exception ("No existe el alumno");
		}
		
	}
	
	
	//Autor: Antonio Garcia
	//10. Poner la falta de la hora en concreto
	public static void ponerFaltasSesion(ArrayList <Alumno> alumnos, String dni, Fecha fechaDia) throws Exception {
		
		//Variables
		DiaClase diaClaseAux=null;
		int horaFalta=0;
		char [] sesiones;
		boolean faltaAsignada=false;
		boolean mismoDia=false;
		int posicion=-1;
		
		//Entradas
		Scanner entrada = new Scanner (System.in);
		
		while(horaFalta<1||horaFalta>6) {
			System.out.println("Hora de la falta");
			horaFalta=entrada.nextInt();
			if(horaFalta<1||horaFalta>6) {
				System.out.println("Debe ser una hora en [1,6]");
			}
				
		}	

		System.out.println("Voy a poner falta el dia: "+fechaDia.getDia()+"/"+fechaDia.getMes()+"/"+fechaDia.getAgno());
		
		//Preguntamos si existe el alumno
		if (alumnos.contains(new Alumno(dni))) {
			
			//Recorremos el Araylist de Alumno
			for (int i = 0; (i < alumnos.size()) && (faltaAsignada==false); i++) {
				if(alumnos.get(i).getDni().equals(dni)) {
					//Cojo el arrayList de faltas del alumno
					ArrayList<DiaClase> faltas=alumnos.get(i).getFaltas();
					if(faltas.size()==0) {
						//**********************************************************************
						System.out.println("El alumno no tenia faltas");
						diaClaseAux = new DiaClase(fechaDia);
						diaClaseAux.getHorario().faltaHora(horaFalta);
						alumnos.get(i).getFaltas().add(diaClaseAux);
						faltaAsignada=true;
					}
					else {//El alumno ya tiene faltas
						//Buscamos en su arraylist faltas si tiene alguna el mismo dia
						//�Tiene faltas el mismo dia?
						System.out.println("El alumno SI TENIA YA faltas");
						for(int j=0;(j<faltas.size()) && (mismoDia==false);j++) {
							
							if(faltas.get(j).getDia().equals(fechaDia)) {
								mismoDia=true;
								posicion=j;
								diaClaseAux=faltas.get(j);
								//sesiones=faltas.get(j).getHorario().getSesiones();//Guardo las sesiones
							}
								
						}
						
						if(mismoDia==true) {
							System.out.println("El alumno tenia faltas EL MISMO DIA");
							//Comprobamos si tiene falta a la misma hora
							if(diaClaseAux.getHorario().getSesiones()[horaFalta-1]=='F') {
								throw new Exception ("El alumno ya tiene falta ese dia en esa sesion");
							}
							else {//Tiene falta el mismo dia, pero en una sesion (hora) distinta, asi que a�adimos la nueva falta
								System.out.println("Voy a ponerle falta a "+(horaFalta-1)+" hora");
								alumnos.get(i).getFaltas().get(posicion).getHorario().faltaHora(horaFalta);
								//diaClaseAux.getHorario().faltaHora(horaFalta-1);
								//alumnos.get(i).getFaltas().add(diaClaseAux);
								faltaAsignada=true;
							}
							
							
						}
						else {//no tiene faltas en ese dia
							System.out.println("La falta es otro dia distinto");
							diaClaseAux = new DiaClase(fechaDia);
							diaClaseAux.getHorario().faltaHora(horaFalta);
							alumnos.get(i).getFaltas().add(diaClaseAux);
							faltaAsignada=true;
						}	
					}
				}		
			}
			
		} else {
			throw new Exception ("No existe el alumno");
		}
	}
	
	//hecho por:juanra
		//pasar lista y poner falta aquel alunmo que no este.
		public static void pasarLista(ArrayList<Alumno> lista) throws Exception {
			//Declaramos variables
			Scanner entrada=new Scanner(System.in);
			int hora;
			int esta;
			int dia, mes, agno;
			int falta;
			Fecha fechaAux;
			DiaClase diaClaseAux;
			
			//Si no hay alumnos, lanzamos excepcion
			if(lista.size()==0) {
				throw new Exception("No hay alumnos dados de alta");
			}
			else {//Si hay alumnos, as� que pasamos lista
				for (int i = 0; i < lista.size(); i++) {//recorrer� lista de alumnos.
					System.out.println("Alumno: "+lista.get(i).getNombre()+" "+lista.get(i).getApellidos());//obtendremos el alumno.
					System.out.println("�Esta?");
					System.out.println("pulsa cualquier tecla para si o 0 para no");
					esta=entrada.nextInt();
					if(esta==0) {//si no esta pediremos el dia y la hora que ha faltado.
						
						//Pedir fecha
						System.out.println("Dime el dia");
						dia=entrada.nextInt();
						System.out.println("Dime el mes");
						mes=entrada.nextInt();
						System.out.println("Dime el a�o");
						agno=entrada.nextInt();
						fechaAux = new Fecha(dia, mes, agno);
						
						ponerFaltasSesion(lista, lista.get(i).getDni(), fechaAux);
						/*do {
							System.out.println("�que hora ha faltado?[1,6]");
							hora=entrada.nextInt();//introduce hora que ha faltado y la asigna.
							falta
							diaClaseAux = new DiaClase(fechaAux);
							diaClaseAux.getHorario().faltaHora(hora);
							lista.get(i).getFaltas().add(diaClaseAux);
						}while(hora<1 || hora>6);*/
						
						/*
						System.out.println("Pulsa cualquier tecla para el dia entero o 0 para una hora");
						falta=entrada.nextInt();
						if(falta==0) {//EL ALUMNO FALTA SOLO UNA HORA
							do {
								System.out.println("�que hora ha faltado?[1,6]");
								hora=entrada.nextInt();//introduce hora que ha faltado y la asigna.
								diaClaseAux = new DiaClase(fechaAux);
								diaClaseAux.getHorario().faltaHora(hora);
								lista.get(i).getFaltas().add(diaClaseAux);
							}while(hora<1 || hora>6);
							//HACER ALGO CON LA HORA ELEGIDA
						}
						else {//FALTA EL DIA ENTERO
							diaClaseAux = new DiaClase(fechaAux);
							diaClaseAux.getHorario().faltaDiaEntero();
							lista.get(i).getFaltas().add(diaClaseAux);
						}*/
					}
					
				}
			}
		}
		
		//hecho por:juanra.
		public static void listarFaltas(ArrayList<Alumno> lista) throws Exception{
			Fecha fechaAux;
			if(lista.size()==0) {
				throw new Exception("No hay alumnos dados de alta");
			}
			else {
				for (int i = 0; i < lista.size(); i++) {//recorrer� lista de alumnos.
					//ArrayList<DiaClase> faltas = lista.get(i).getFaltas();//obtenemos lista faltas
					System.out.println("alumno: "+lista.get(i).getNombre());
					for(int j=0; j<lista.get(i).getFaltas().size();j++) {
						fechaAux=lista.get(i).getFaltas().get(j).getDia();
						System.out.println("\nDia: "+fechaAux.getDia()+"/"+fechaAux.getMes()+"/"+fechaAux.getAgno());
						lista.get(i).getFaltas().get(j).getHorario().imprimeHora();
					}
				}
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
			
				//M�todo dar de alta alumno (Daniel Moreno)
				case 1:
					
					//Variables
					boolean repetir1 = true;
					int opcion1;
					
					//Bucle para repetir la opci�n de dar de alta si se desea
					while(repetir1 == true) {
						try {
							PracticaGrupoMain.altaAlumno(alumnos);
						}catch(Exception ex) {
							System.out.println(ex.getMessage());
						}
						repetir1 = repetimos();
					}
					
					break;
				
					//M�todo dar de baja alumno (Daniel Moreno)
				case 2:
					
					//Variables
					boolean repetir2 = true;
					int opcion2;
					
					//Bucle para repetir la opci�n de dar de alta si se desea
					while(repetir2 == true) {
					
						try {
							PracticaGrupoMain.bajaAlumno(alumnos);
											
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						repetir2 = repetimos();
					}
					
					break;
		
		//Listar los alumnos		
				case 3:

					try {
						listarAlumnos(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

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

						System.out.print(ex.getMessage());
						
					}
					
				
					//listarFaltas(alumnos);
				
					
					break;
					
				case 10:
					String dni="11";
					Fecha faltas=null;
				
				try {
					faltas = new Fecha(1,1,2019);
				} catch (Exception ex) {
					
					System.out.println(ex.getMessage());
				}
					try {
						
						ponerFaltasSesion (alumnos,dni,faltas);
						
					} catch (Exception ex) {

						System.out.println(ex.getMessage());
						
					}
					
					//listarFaltas(alumnos);
					
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
					try {
						listarFaltas(alumnos);
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					
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

