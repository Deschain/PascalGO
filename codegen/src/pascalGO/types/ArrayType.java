package pascalGO.types;

public class ArrayType extends Type {

	private String type;
	private int rangoInferior = 0;
	private int rangoSuperior = 0;
	
	public ArrayType(){
		super();
	}
	
	public ArrayType(String name) {
		super(name);
	}
	
	public ArrayType(String name, String type, int rangoInferior, int rangoSuperior){
		super(name);
		this.type = type;
		this.rangoInferior = rangoInferior;
		this.rangoSuperior = rangoSuperior;
	}
	
	public boolean checkRange(){		
		if(rangoSuperior<rangoInferior){
			return false;
		}else{
			return true;
		}
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
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
	
}
