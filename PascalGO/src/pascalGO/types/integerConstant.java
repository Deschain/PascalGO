package pascalGO.types;

import pascalGO.grammar.Token;

public class integerConstant extends BasicType{
	
	private int value;
	private char signo;
	
	public integerConstant(Token token, int value, char signo){
		super(token);
		this.value = value;
		this.signo = signo;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getSigno() {
		return signo;
	}

	public void setSigno(char signo) {
		this.signo = signo;
	}
	

}
