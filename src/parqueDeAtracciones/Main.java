package parqueDeAtracciones;
import java.util.Scanner;
import persistencias.Persistencia;
import parqueDeAtracciones.*;



public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Parque parque = Persistencia.cargarParque();
		while (true) {
			System.out.println("\n PARQUE DE ATRACCIONES");
			System.out.println("1. Ingresar como administrador del parque.");
			System.out.println("2. Ingresar como empleado del parque.");
			System.out.println("3. Ingresar como Cliente del parque.");
			System.out.println("4. Salir.");
			System.out.print("Seleccione una opcion: ");
			
			String op = scanner.nextLine();
			switch (op) {
			case "1":
				consolaAdministrador.iniciar(parque, scanner);
				
			}
		}

		
	}

}
