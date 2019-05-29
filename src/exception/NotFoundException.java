package exception;

/**
 * Clase para lanzar una excepción en el momento que un jugador buscado no sea encontrado
 * @author W-7
 *
 */

public class NotFoundException extends Exception{

	/**
	 * 
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
