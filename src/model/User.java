package model;

public class User {

	public static final String[] DOCUMENTTYPE = { "Cedula de ciudadania", "Tarjeta de identidad", "Registro civil",
			"Pasaporte", "Cedula de extranjeria" };

	private String documentType;
	private int id;
	private String name;
	private String lastName;
	private String pNumber;
	private String address;
	

	/**
	 * @param documentType
	 * @param id
	 * @param name
	 * @param lastName
	 * @param pNumber
	 * @param address
	 */
	public User(int documentType, int id, String name, String lastName, String pNumber, String address) {

		this.documentType = DOCUMENTTYPE[documentType - 1];
		this.id = id;
		this.name = name;
		this.lastName = lastName;

		if (pNumber.equals("")) {
			this.pNumber = "No registra";

		}

		if (pNumber.equals("")) {
			this.pNumber = "No registra";

		}

		this.pNumber = pNumber;
		this.address = address;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static String msgTypeDoc() {
		String s = "";

		for (int i = 0; i < DOCUMENTTYPE.length; i++) {
			s += (i + 1) + ". " + DOCUMENTTYPE[i] + "\n";
		}

		return s;
	}

	@Override
	public String toString() {
		return "User [documentType=" + documentType + ", id=" + id + ", name=" + name + "]";
	}

	public String getCompleteName() {
		return name + " " + lastName;
	}

}
