package pascalGO.types;


/**
 * Class for storing Array types in the Symbol Table
 * @See PascalGO.types.Type.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class ArrayType extends Type {

	private String type;
	private int rangoInferior = 0;
	private int rangoSuperior = 0;
	
	/**
	 * Default constructor
	 */
	public ArrayType(){
		super();
	}
	
	/**
	 * Constructor with name
	 * @param name id of the Array
	 */
	public ArrayType(String name) {
		super(name);
	}
	
	/**
	 * Constructor 
	 * @param name id of the array
	 * @param type of the array
	 * @param rangoInferior lower limit of the range
	 * @param rangoSuperior upper limit of the range
	 */
	public ArrayType(String name, String type, int rangoInferior, int rangoSuperior){
		super(name);
		this.type = type;
		this.rangoInferior = rangoInferior;
		this.rangoSuperior = rangoSuperior;
	}
	
	/**
	 * validates if the range of the array is correct
	 * @return true if rango inferior is less than rango superior
	 */
	public boolean checkRange(){		
		if(rangoSuperior<rangoInferior){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the rangoInferior
	 */
	public int getRangoInferior() {
		return rangoInferior;
	}

	/**
	 * @param rangoInferior the rangoInferior to set
	 */
	public void setRangoInferior(int rangoInferior) {
		this.rangoInferior = rangoInferior;
	}

	/**
	 * @return the rangoSuperior
	 */
	public int getRangoSuperior() {
		return rangoSuperior;
	}

	/**
	 * @param rangoSuperior the rangoSuperior to set
	 */
	public void setRangoSuperior(int rangoSuperior) {
		this.rangoSuperior = rangoSuperior;
	}
	
}
