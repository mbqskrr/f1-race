package exception;

/**
 * Clase para lanzar una excepción en el mometo en el que el nombre de un jugador no sea válido
 * @author Manuel Balanta
 *
 */

@SuppressWarnings("serial")
public class NickNameExcpetion extends Exception{
	
	/**
	 * Método constructor
	 * @param message mensaje para lanzar la excepción
	 */
	public NickNameExcpetion(String message) {
		super(message);
	}
	
}
