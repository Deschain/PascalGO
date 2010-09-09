package pascalGO.types;

public class ArrayType extends BasicType {

	private String name;
	private int rangoInferior = 0;
	private int rangoSuperior = 0;
	
	public ArrayType(String name) {
		super();
		this.name = name;
	}
	
	public ArrayType(String name, String type, int rangoInferior, int rangoSuperior){
		super(type);
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
