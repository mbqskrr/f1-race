package exception;

/**
 * 
 * @author Manuel Balanta
 *
 */

@SuppressWarnings("serial")
public class RepeatedNickNameExcpetion extends Exception{
	
	public RepeatedNickNameExcpetion(String message) {
		super(message);
	}
	
}
