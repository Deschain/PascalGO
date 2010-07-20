package pascalGO.types;

import pascalGO.grammar.Token;

public class Variable extends BasicType {
	
	private Type type;
	private String access;

	public Variable(Token token, Type type, boolean access) {
		super(token);
		this.type = type;
		if (access){
			this.access = new String("dir");
		}else{
			this.access = new String("ref");
		}
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
	public void setAccess(boolean access){
		if (access){
			this.access = new String("dir");
		}else{
			this.access = new String("ref");
		}
	}
	

}
