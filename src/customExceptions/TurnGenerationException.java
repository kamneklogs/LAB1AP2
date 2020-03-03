package customExceptions;

@SuppressWarnings("serial")
public class TurnGenerationException extends Exception {

	public TurnGenerationException() {
		super("No se pueden atender turnos actualmente, intente mas tarde");
	}


}