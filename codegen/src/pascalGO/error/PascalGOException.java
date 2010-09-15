package pascalGO.error;

import pascalGO.grammar.ParseException;
import pascalGO.grammar.PascalGO;

/**
 * Exception class, used in the jjt to communicate the errors
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class PascalGOException extends ParseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public PascalGOException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * @param ex error message
	 */
	public PascalGOException(String ex) {
		super(ex + ". At " + PascalGO.token.beginLine + ","
				+ PascalGO.token.beginColumn);
	}
}
