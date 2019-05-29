package exception;

/**
 * Clase para lanzar una excepci�n en el momento que un jugador buscado no sea encontrado
 * @author Manuel Balanta
 *
 */

public class NotFoundException extends Exception{

	/**
	 * Constate
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de la excepci�n
	 * @param msg - mensaje para el momento de lanzar la excepci�n
	 */
	public NotFoundException(String msg) {
		super(msg);
	}
	

}
