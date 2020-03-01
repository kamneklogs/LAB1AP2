package model;

import customExceptions.*;
import java.util.ArrayList;

public class MasterClassTurns {

	private ArrayList<User> dataBaseUsers;
	private ArrayList<Turn> turns;

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

	public int binarySearch(int id) {

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

		return -1;

	}
	
	public void generateTurn(int idUser) {
		if(turns.isEmpty()) {
			turns.add(new Turn("A00", idUser));
		}
		
		
		
	}

}
