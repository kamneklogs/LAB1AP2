
package ui;

import java.util.Scanner;

import model.User;

public class Turns {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);

		int opt;
		int documentTypeOpt;
		String id;
		String name;
		String lastName;
		String pNumber;
		String address;

		do {
			System.out.println(
					"\tGESTION DE TURNOS\t\nEscoja la opcion que desee realizar:\n\n1. Agregar usuario.\n2. Registrar turno.\n3. Atender turno.\n4. salir.\n ");
			opt = r.nextInt();

			switch (opt) {
			case 1:

				System.out.println(User.msgTypeDoc());
				documentTypeOpt = r.nextInt();
				System.out.println("Ingrese el numero de documento: ");
				System.out.println("Ingrese el primer nombre:");
				System.out.println("Ingrese el primera apellido");

				break;
				
				

			default:
				break;
			}

		} while (opt != 4);

	}

}
