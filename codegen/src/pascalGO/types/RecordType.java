package pascalGO.types;

import java.util.ArrayList;

/**
 * Class for storing Record types in the Symbol Table
 * @See PascalGO.types.Type.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
public class RecordType extends Type{
	
	private ArrayList<Variable> variables;
	
	/**
	 * Default constructor
	 */
	public RecordType(){
		super();
	}
	
	/**
	 * Default constructor
	 * @param name the name of the Record
	 */
	public RecordType(String name){
		super(name);
	}
	
	/**
	 * Adds variable to the Record
	 * @param var
	 */
	public void addVariable(Variable var){
		this.variables.add(var);
	}
	
	/**
	 * Returns the variable stored at the position index 
	 * @param index the position of the Variable to be returned
	 * @return the variable
	 */
	public Variable getVariable(int index){
		return this.variables.get(index);
	}

	/**
	 * Sets the variables of the Record to v
	 * @param v the new ArrayList of variables
	 */
	public void setVariables(ArrayList<Variable> v){
		variables = v;
	}
	
	/**
	 * Merges with the stored variables the variables from v keeping the order
	 * @param v the ArrayList of Variables to be stored
	 */
	public void merge (ArrayList<Variable> v){
		if (variables == null)
			variables = new ArrayList<Variable>();
		variables.addAll(v);
	}
	
	/**
	 * Returns the variable stored that has the id name
	 * @param name search parameter
	 * @return the Variable with name as an id or null of none where found
	 */
	public Variable getVariable (String name){
		for (Variable v: variables)
			if (v.getName().equals(name))
				return v;
		return null;
	}
}
