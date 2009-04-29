package pascalGO.types;

public class ArrayType extends Variable {

	public static final String ARRAY = "array";
	
	private int rangoInferior = 0;
	private int rangoSuperior = 0;
	
	private Variable kind = null;
	
	public ArrayType(String name){
		super(name,ARRAY);
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

	public Variable getKind() {
		return kind;
	}

	public void setKind(Variable kind) {
		this.kind = kind;
	}
	
	//Method that calculates if the bounds of the array are right
	public boolean rangoCorrecto(){
		if(rangoSuperior > rangoInferior){
			return true;
		}else{
			return false;
		}
	}
	
}
