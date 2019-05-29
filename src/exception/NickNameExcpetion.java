package exception;

/**
 * Clase para lanzar una excepci�n en el mometo en el que el nombre de un jugador no sea v�lido
 * @author Manuel Balanta
 *
 */

@SuppressWarnings("serial")
public class NickNameExcpetion extends Exception{
	
	/**
	 * M�todo constructor
	 * @param message mensaje para lanzar la excepci�n
	 */
	public NickNameExcpetion(String message) {
		super(message);
	}
	
}
