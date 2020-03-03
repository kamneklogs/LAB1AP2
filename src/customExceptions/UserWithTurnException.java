package customExceptions;

@SuppressWarnings("serial")
public class UserWithTurnException extends Exception {

	public UserWithTurnException(int id) {
		super("El usuario con numero de identificacion " + id + " ya posee  un turno activo");

	}

}
