package Garage;

import java.util.Scanner;

public class Main {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		

		Garaje garaje = new Garaje();

		boolean finalizar = false;
		while (!finalizar) {
			System.out.println("\t __________________________________");
			System.out.println("\t Estadisticas");
			System.out.println("\t ------------ \n");
			System.out.println("\t 1. Registrar trabajo");
			System.out.println("\t 2. Aumenta horas");
			System.out.println("\t 3. Aumenta coste piezas");
			System.out.println("\t 4. Finaliza trabajo");
			System.out.println("\t 5. Muestra trabajo");
			System.out.println("\t 6. Salir del programa");
			System.out.println("\t    Opcion: ");
			System.out.println("\t __________________________________");
			int opcion = Integer.parseInt(entrada.nextLine());
			int error=0;

			// REGISTRAR TRABAJO
			if (opcion == 1) {
				System.out.println("\t __________________________________");
				System.out.println("\t Opciones");
				System.out.println("\t ------------ \n");
				System.out.println("\t 1. Revision");
				System.out.println("\t 2. Reparacion mecanica");
				System.out.println("\t 3. Reparacion chapa y pintura");
				opcion = Integer.parseInt(entrada.nextLine());

				if (opcion >= 1 && opcion <= 3) {
					System.out.println("Descripcion:");
					int ident = garaje.registra(entrada.nextLine(), opcion);
					System.out.println("Trabajo con identificador "+ ident + " creado correctamente.");
				} else {
					System.out.println("Opcion no valida.");
				}
				
			// AUMENTA HORAS
			} else if (opcion == 2) {
				System.out.println("ID del trabajo al que aumentar horas:");
				int ident = Integer.parseInt(entrada.nextLine());
				if(garaje.existeTrabajo(ident)) {
					System.out.println("Numero de horas a aumentar:");
					error = garaje.aumentaHoras(ident, Integer.parseInt(entrada.nextLine()));
					controlErrores(error);
				}
				else controlErrores(0);
				

			// AUMENTA COSTE PIEZAS
			} else if (opcion == 3) {
				System.out.println("ID del trabajo al que aumentar el coste de las piezas:");
				int ident = Integer.parseInt(entrada.nextLine());
				if(garaje.existeTrabajo(ident)) {
					System.out.println("Coste de las piezas:");
					float coste = Float.parseFloat(entrada.nextLine());
					error = garaje.aumentaCoste(ident,coste);
					controlErrores(error);
				}
				else controlErrores(0);
			}

			// FINALIZA TRABAJO
			else if (opcion == 4) {
				System.out.println("ID del trabajo a finalizar:");
				int ident = Integer.parseInt(entrada.nextLine());
				if(garaje.existeTrabajo(ident)) {
					garaje.finalizarTrabajo(ident);
				}
				else controlErrores(0);
				
			}

			// MUSTRA TRABAJO
			else if (opcion == 5) {
				System.out.println("ID del trabajo a mostrar:");
				int ident = Integer.parseInt(entrada.nextLine());
				if(garaje.existeTrabajo(ident)) {
					System.out.println(garaje.muestraTrabajo(ident));	
				}
				else controlErrores(0);
			}
			
			// SAL DEL PROGRAMA
			else if (opcion == 6) {
				finalizar = true;
			}
			else {
				System.out.println("Opcion no valida");
			}
		}
	}
	public static void controlErrores(int error) {
		if(error == 0) {    //Si el identificador introducido no existe
			System.out.println("El trabajo con el identificador no existe.");
		}
		else if(error ==-1) {  //Si al intentar aumentar el coste de las piezas no es reparacion da error
			System.out.println("Este trabajo no tiene coste de piezas.");
		}
		else if(error ==-2) {
			System.out.println("El trabajo ya esta finalizado y no se puede modificar.");
		}
		else if(error ==-3) {
			System.out.println("El trabajo tiene horas negativas.");
		}
	}
}
