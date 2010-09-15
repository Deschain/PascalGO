package pascalGO.types;

/**
 * Class for storing Variables in the Symbol Table
 * @See PascalGO.types.BasicType.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class Variable extends BasicType {

	private String type;
	private String access;

	/**
	 * Default Constructor
	 * @param name the name/id of the Variable
	 */
	public Variable (String name){
		super(name);
		this.access = null;
	}
	
	/**
	 * Default Constructor
	 * @param name the name/id of the Variable
	 * @param type the type of the variable
	 */
	public Variable(String name, String type){
		super(name);
		this.type = type;
		this.access = null;
	}
	
	/**
	 * Default Constructor
	 * @param name the name/id of the Variable
	 * @param type the type of the Variable
	 * @param access the access type of the Variable.
	 */
	public Variable(String name, String type, String access){
		super(name);
		this.type = type;
		this.access = access;
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

	/**
	 * @return the access
	 */
	public String getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(String access) {
		this.access = access;
	}


}
