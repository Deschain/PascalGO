package pascalGO.types;

import pascalGO.grammar.Token;

public class logicConstant extends BasicType{

	private boolean value;
	
	public logicConstant(Token token, boolean value){
		super(token);
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
