package pascalGO.error;

import pascalGO.grammar.ParseException;
import pascalGO.grammar.PascalGO;
import pascalGO.grammar.Token;

public class PascalGOException extends ParseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PascalGOException() {
		// TODO Auto-generated constructor stub
	}
	public PascalGOException(String ex){
		super(ex +" at "+PascalGO.token.beginLine+"," +PascalGO.token.beginColumn );		
	}
}
