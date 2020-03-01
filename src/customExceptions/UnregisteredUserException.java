package customExceptions;

@SuppressWarnings("serial")
public class UnregisteredUserException extends Exception {

	private int documentNumber;

	public UnregisteredUserException(int documentNumber, String documentType) {
		super("The document number " + documentNumber + " with document type " + documentType
				+ " is not register in our base date, please do it.");
		setDocumentNumber(documentNumber);
	}

	public int getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}

}
