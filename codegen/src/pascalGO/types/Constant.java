package pascalGO.types;


/**
 * Class for storing Constants types in the Symbol Table
 * @See PascalGO.types.BasicType.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class Constant extends BasicType {

	private String value;
	private String type;
	
	/**
	 * Default constructor
	 * @param name the name of the constant
	 * @param value the value of the constant
	 */
	public Constant(String name, String value){
		super(name);
		this.value = value;
		this.type = null;
	}
	
	/**
	 * Constructor
	 * @param name name of the Constant
	 * @param value value of the Constant
	 * @param type Type of the constant
	 */
	public Constant(String name, String value,String type){
		super(name);
		this.value = value;
		this.type = type;
	}
	
	/**
	 * returns if the value of the constant is integer
	 * @return true if the value of the constant is integer
	 */
	public boolean isNumeric(){
		try{
			Integer.parseInt(value);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type.toLowerCase();
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
