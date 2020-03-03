package model;

import customExceptions.*;
import java.util.ArrayList;

public class MasterClassTurns {

	private ArrayList<User> dataBaseUsers;
	private ArrayList<Turn> turns;
	private Turn actualT;

	public MasterClassTurns() {

		dataBaseUsers = new ArrayList<User>();
		turns = new ArrayList<Turn>();

	}

	public ArrayList<Turn> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}

	public ArrayList<User> getDataBaseUsers() {
		return dataBaseUsers;
	}

	public void setDataBaseUsers(ArrayList<User> dataBaseUsers) {
		this.dataBaseUsers = dataBaseUsers;
	}

	public int searchUser(String documentType, int id) throws UnregisteredUserException {

		int index = binarySearch(id);

		if (index == -1) {
			throw new UnregisteredUserException(id, documentType);
		}

		if (!(dataBaseUsers.get(index).getDocumentType().equals(documentType))) {
			throw new UnregisteredUserException(id, documentType);
		}

		return index;

	}

	public int searchUser(int id) throws UnregisteredUserException {

		int index = binarySearch(id);

		if (index == -1) {
			throw new UnregisteredUserException(id);
		}

		return index;

	}

	public String searchInTurns(int id) {

		String respectiveTurn = "";
		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i).getIdUser() == id) {
				respectiveTurn = turns.get(i).getNameT();
				break;
			}
		}

		return respectiveTurn;
	}

	public boolean validTurn(int id) {
		boolean b = false;

		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i).getIdUser() == id) {
				return true;
			}
		}

		return b;
	}

	public int binarySearch(int id) throws UnregisteredUserException {

		if (dataBaseUsers.size() == 1) {
			if (dataBaseUsers.get(0).getId() == id) {
				return 0;
			} else {
				throw new UnregisteredUserException(id);
			}
		} else {
			dataBaseUsers.sort(new sortById());
			int numId = id;

			int middle, down = 0, up = dataBaseUsers.size();

			while (down <= up) {
				middle = (up + down) / 2;
				if (dataBaseUsers.get(middle).getId() == numId)
					return middle;
				else if (numId < dataBaseUsers.get(middle).getId())
					up = middle - 1;
				else
					down = middle + 1;
			}

		}
		return -1;

	}

	public boolean generateTurn(int idUser) throws UserWithTurnException {

		if (validTurn(idUser)) {
			throw new UserWithTurnException(idUser);
		}

		if (turns.isEmpty()) {
			turns.add(new Turn("A00", idUser));
			actualT = turns.get(0);
			return true;
		}

		String t = generateNextTurn(turns.get(turns.size() - 1).getNameT());

		turns.add(new Turn(t, idUser));

		return true;

	}

	public String generateNextTurn(String actualTurn) {
		String s = "";

		int numberPart = Integer.parseInt(actualTurn.substring(1));
		char letter = actualTurn.charAt(0);

		if (numberPart != 99 && numberPart < 10) {
			s = letter + "0" + Integer.toString(numberPart + 1);
		} else if (numberPart != 99 && numberPart >= 10) {
			s = letter + Integer.toString(numberPart + 1);
		} else {
			s = (char) (letter + 1) + "00";
		}

		return s;
	}

	public int searchActualT(String namePreTurn) {
		int index = -1;
		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i).getNameT().equals(namePreTurn)) {
				index = i ;
				break;
			}
		}
		return index;
	}

	public String showActualTurn() throws UnregisteredUserException, TurnGenerationException {
		String a = "El turno actual es ";

		if (actualT.getNameT().equals("A00")) {
			a += actualT.getNameT() + " y le corresponde a "
					+ dataBaseUsers.get(binarySearch(actualT.getIdUser())).getCompleteName();
			actualT = turns.get(searchActualT(actualT.getNameT()));
		} else {
			if (searchActualT(actualT.getNameT()) == -1) {
				throw new TurnGenerationException();
			} else {
				
				actualT = turns.get(searchActualT(actualT.getNameT()));
			}
			a = actualT.getNameT() + " y le corresponde a "
					+ dataBaseUsers.get(binarySearch(actualT.getIdUser())).getCompleteName();
		}
		actualT = turns.get(searchActualT(actualT.getNameT()));
		return a;
	}

}
