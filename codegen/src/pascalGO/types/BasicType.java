package pascalGO.types;

/**
 * Parent class for all elements to be stored in the Symbol Table
 * @See PascalGO.table.SymbolTable.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class BasicType {

	private String name;
	private boolean used = false;
	
	/**
	 * Default constructor
	 */
	public BasicType(){
		name = null;	
		this.used = false;
	}
	
	/**
	 * Default constructor
	 * @param name String name/id of the element.
	 */
	public BasicType(String name){
		this.name = name;
		this.used = false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name.toLowerCase();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * @param used the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}

}
