package pascalGO.types;

import pascalGO.grammar.Token;

public abstract class BasicType {
	
	protected Token token;
	
	public Token getToken() {
		return token;
	}
	public void setName(Token token) {
		this.token = token;
	}
	public BasicType(Token token){
		this.token = token;
	}
	
	public String getName(){
		return token.image;
	}

}
