package customExceptions;

@SuppressWarnings("serial")
public class UnregisteredUserException extends Exception {

	public UnregisteredUserException(int documentNumber) {
		super("El numero de documento " + documentNumber
				+ " no fue encontrado en  nuestra base de datos, intente nuevamente.");

	}

	public UnregisteredUserException(int documentNumber, String documentType) {
		super(documentType + " con el numero " + documentNumber + " no fue encontrado en nuestra base de datos");

	}

}
