
package ui;

import java.util.Scanner;

import customExceptions.UnregisteredUserException;
import model.MasterClassTurns;
import model.User;

public class Turns {

	MasterClassTurns myMasterClass;
	static Scanner r = new Scanner(System.in);

	static int opt;

	Turns() {
		myMasterClass = new MasterClassTurns();
	}

	public void addUser() {

		int documentTypeOpt;
		int id;
		String name;
		String lastName;
		String pNumber;
		String address;

		System.out.println(User.msgTypeDoc());
		documentTypeOpt = r.nextInt();
		System.out.println("Ingrese el numero de documento: ");
		r.nextLine();
		id = r.nextInt();
		System.out.println("Ingrese el primer nombre:");
		r.nextLine();
		name = r.nextLine();
		System.out.println("Ingrese el primera apellido");
		lastName = r.nextLine();
		System.out.println("Ingrese la direccion (Opcional)");
		address = r.nextLine();
		System.out.println("Ingrese numero de telefono (Opcional)");
		pNumber = r.nextLine();

		myMasterClass.getDataBaseUsers().add(new User(documentTypeOpt, id, name, lastName, pNumber, address));
		System.out.println("Usuario registrado exitosamente\n\n");
	}

	public void addTurn() {
		int documentTypeOpt = 0, id;
		String documentType = "";

		System.out.println("Elija su tipo de documento: \n" + User.msgTypeDoc());

		boolean correct = true;

		documentTypeOpt = r.nextInt();

		do {
			switch (documentTypeOpt) {
			case 1:
				documentType = User.DOCUMENTTYPE[0];
				break;

			case 2:
				documentType = User.DOCUMENTTYPE[1];
				break;

			case 3:
				documentType = User.DOCUMENTTYPE[2];
				break;

			case 4:
				documentType = User.DOCUMENTTYPE[3];
				break;

			case 5:
				documentType = User.DOCUMENTTYPE[4];
				break;

			default:
				System.out.println("Opcion Invalida, vuelva a escoger:\n");
				correct = false;

			}

		} while (correct == false);

		System.out.println("Ingrese su numedo de identificacion: ");
		id = r.nextInt();

		try {
			System.out.println(myMasterClass.searchUser(documentType, id));
		} catch (UnregisteredUserException e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		Turns app = new Turns();

		do {
			System.out.println(
					"\tGESTION DE TURNOS\t\nEscoja la opcion que desee realizar:\n\n1. Agregar usuario.\n2. Registrar turno.\n3. Atender turno.\n4. salir.\n ");
			opt = r.nextInt();

			switch (opt) {
			case 1:
				app.addUser();
				break;

			case 2:
				app.addTurn();
				break;

			default:
				break;
			}

		} while (opt != 4);

	}

}
