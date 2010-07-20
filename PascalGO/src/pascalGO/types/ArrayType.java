package pascalGO.types;

import pascalGO.grammar.Token;

public class ArrayType extends BasicType {

	private int rangoInferior = 0;
	private int rangoSuperior = 0;
	private String type;
		
	public ArrayType(Token token, int inf, int sup, String type){
		super(token);
		this.rangoInferior = inf;
		this.rangoSuperior = sup;
		this.type = type;
	}

	public int getRangoInferior() {
		return rangoInferior;
	}

	public void setRangoInferior(int rangoInferior) {
		this.rangoInferior = rangoInferior;
	}

	public int getRangoSuperior() {
		return rangoSuperior;
	}

	public void setRangoSuperior(int rangoSuperior) {
		this.rangoSuperior = rangoSuperior;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	

}
