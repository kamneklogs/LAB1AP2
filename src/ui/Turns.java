
package ui;

import java.util.Scanner;

import customExceptions.TurnGenerationException;
import customExceptions.UnregisteredUserException;
import customExceptions.UserWithTurnException;
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
		int id;

		System.out.println("Elija su tipo de documento: \n" + User.msgTypeDoc());

		r.nextInt();

		System.out.println("Ingrese su numero de identificacion: ");
		id = r.nextInt();

		try {
			myMasterClass.generateTurn(id);
			System.out.println("\n\nTurno: " + myMasterClass.searchInTurns(id) + " asignado al usuario "
					+ myMasterClass.getDataBaseUsers().get(myMasterClass.binarySearch(id)).getCompleteName());
		} catch (UnregisteredUserException e) {
			System.out.println(e);
		} catch (UserWithTurnException e) {
			System.out.println(e);
		}

	}

	public void takeActualTurn() {

		boolean b = false;

		do {

			try {
				System.out.println(myMasterClass.showActualTurn());

				System.out.println("1. Turno atendido.\n2. Usuario no se encuentra presente");
				opt = r.nextInt();

				System.out.println("Atender al turno siguiente?\n 1. Si.\n 2. No, volver al menu principal.\n");
				opt = r.nextInt();
				if (opt == 1) {
					b = true;
				} else {
					b = false;
				}
			} catch (UnregisteredUserException e) {
				System.out.println(e);
			} catch (TurnGenerationException e) {
				System.out.println(e);
				e.printStackTrace();
			}

		} while (b);

	}

	public static void main(String[] args) {

		Turns app = new Turns();

		do {
			System.out.println(
					"\n\tGESTION DE TURNOS\t\nEscoja la opcion que desee realizar:\n\n1. Agregar usuario.\n2. Registrar turno.\n3. Atender turno.\n4. salir.\n ");
			opt = r.nextInt();

			switch (opt) {
				case 1:
					app.addUser();
					break;

				case 2:
					app.addTurn();
					break;

				case 3:
					app.takeActualTurn();
					break;

				case 4:
					System.out.println("\nGracias por usar TurnsApp Deluxe V1.0");
					break;

				default:
					System.out.println("Opcion invalida, vuelva a intentarlo\n");
					break;
			}

		} while (opt != 4);

	}

}
