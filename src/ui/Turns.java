package ui;

import java.util.Scanner;

public class Turns {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		int opt;
		
		
		
		do {
			System.out.println("\tGESTION DE TURNOS\t\nEscoja la opcion que desee realizar:\n\n1. Agregar usuario.\n2. Registrar turno.\n3. Atender turno.\n4. salir.\n ");	
			opt  = r.nextInt();
			
			switch (opt) {
			case 1:
				
				break;

			default:
				break;
			}
			
		}while(opt!=4);
		
	}

}
