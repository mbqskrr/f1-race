package exception;

/**
 * Clase para lanzar una excepción en el momento que un jugador buscado no sea encontrado
 * @author Manuel Balanta
 *
 */

public class NotFoundException extends Exception{

	/**
	 * Constate
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de la excepción
	 * @param msg - mensaje para el momento de lanzar la excepción
	 */
	public NotFoundException(String msg) {
		super(msg);
	}
	

}
