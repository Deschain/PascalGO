package pascalGO.types;

/**
 * Class for storing Types in the Symbol Table
 * @See PascalGO.types.BasicType.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
import pascalGO.types.BasicType;

public class Type extends BasicType {

	/**
	 * Default constructor
	 */
	public Type (){
		super();
	}
	
	/**
	 * Default constructor
	 * @param name the name of the type
	 */
	public Type (String name){
		super(name);
	}
	
	/**
	 * Comparative method to check if 2 Types are the same
	 * @param t the other type
	 * @return true if the names of the types are equal (not case sentitive)
	 */
	public boolean equals(Type t){
		return this.getName().toLowerCase().equals(t.getName().toLowerCase());
	}
}
