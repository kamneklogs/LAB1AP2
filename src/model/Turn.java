package model;

public class Turn {
	private String nameT;
	private int idUser;

	public Turn(String nameT, int idUser) {
		this.nameT = nameT;
		this.idUser = idUser;
	}

	public String getNameT() {
		return nameT;
	}

	public void setNameT(String nameT) {
		this.nameT = nameT;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
