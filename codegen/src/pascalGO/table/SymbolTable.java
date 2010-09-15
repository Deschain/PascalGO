package pascalGO.table;


/**
 * Class for storing Record types in the Symbol Table
 * @See PascalGO.types.BasicType.java
 * @author Óscar Rodriguez Zaloña
 * @author Gonzalo José Canelada
 */
import java.util.ArrayList;
import java.util.Hashtable;

import pascalGO.types.*;

public class SymbolTable {

	private ArrayList<Hashtable<String, BasicType>> levels;
	private int actualLevel;

	/**
	 * Default constructor
	 */
	public SymbolTable() {
		this.actualLevel = 0;
		this.levels = new ArrayList<Hashtable<String, BasicType>>();
		levels.add(actualLevel, new Hashtable<String, BasicType>());
	}

	/**
	 * Creates a new level in the Symbol Table and set the current level to the new
	 */
	public void openLevel() {
		this.actualLevel++;
		levels.add(actualLevel, new Hashtable<String, BasicType>());
	}

	/**
	 * Reduces the actual level, and removes the level 
	 */
	public void eraseLevel() {
		levels.remove(actualLevel);
		this.actualLevel--;
	}

	/**
	 * Looks for the Element with id name in the current level	
	 * @param name the id
	 * @return null, if not found, otherwise the element with id name
	 */
	public BasicType localSearch(String name) {
		return levels.get(actualLevel).get(name);
	}

	/**
	 * Looks for the Element with id name in the whole table
	 * @param name the id
	 * @return null, if not found, otherwise the element with id name
	 */
	public BasicType totalSearch(String name) {
		int level = actualLevel;
		BasicType totalSearchResult = null;
		while (level >= 0 && totalSearchResult == null) {
			totalSearchResult = levels.get(level).get(name);
			level--;
		}
		return totalSearchResult;
	}
	
	/**
	 * Checks if the table has an element with id name
	 * @param name the id
	 * @return true if the table contains such an element, flase otherwise
	 */
	public boolean has(String name){
		return (totalSearch(name) != null);	
	}
	
	/**
	 * Checks if the table has an element with the same name as type
	 * @param type the type to check
	 * @return true if the table contains such an element, false otherwise
	 */
	public boolean has(BasicType type){
		return (totalSearch(type.getName()) != null);
			
	}
	
	/**
	 * Adds a new Element to the current level of the table
	 * @param bt the element to be added
	 */
	public void add(BasicType bt){
		levels.get(actualLevel).put(bt.getName(),bt);
	}
}
