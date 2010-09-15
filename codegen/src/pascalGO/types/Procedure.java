package pascalGO.types;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Class for storing Procedure types in the Symbol Table
 * @See PascalGO.types.Type.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class Procedure extends BasicType{

	/**
	 * Stores the Variables according to their ID
	 */
	private Hashtable<String, Variable> parameters;
	/**
	 * Stores the ID of the variables in the hashtable preserving the order of addition
	 */
	private ArrayList<String> indexHashtable;
	
	/**
	 * Default constructor
	 * @param name the name of the Array type
	 */
	public Procedure (String name){
		super(name);
		parameters = new Hashtable<String, Variable>();
		indexHashtable = new ArrayList<String>();
	}

	/**
	 * Adds a new Vriable to the procedure
	 * @param parameter the variable to be added
	 */
	public void addVariable(Variable parameter){
		indexHashtable.add(parameter.getName());
		parameters.put(parameter.getName(), parameter);
	}
	
	/**
	 * Returns the variable with id name
	 * @param name the id of the variable
	 * @return the variable with id name
	 */
	public Variable getVariable(String name){
		return parameters.get(name);
	}
	
	/**
	 * Return the variable added in idex position.
	 * @param index the index of the variable to return
	 * @return the variable in position index
	 */
	public Variable getVariable(int index){
		return parameters.get(indexHashtable.get(index));
	}
	
	/**
	 * Returns the parameters stored
	 * @return The parameters stored in the hashtable, doesn't maintain order.
	 */
	public ArrayList<Variable> getParameters(){
		return new ArrayList<Variable>(this.parameters.values());
	}
	
	/**
	 * Stores a new set of Variables
	 * @param params the ArrayList of new Variables
	 */
	public void merge (ArrayList <Variable> params){
		for (Variable parameter : params){
			indexHashtable.add(parameter.getName());
			parameters.put(parameter.getName(), parameter);
			
		}
	}
	
	/**
	 * Returns the type of the Variable in position index
	 * @param index the position of the variable
	 * @return the type of the variable in positoin index
	 */
	public String getType(int index){
		return parameters.get(indexHashtable.get(index)).getType();
	}
}
