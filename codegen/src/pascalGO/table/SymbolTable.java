package pascalGO.table;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import pascalGO.types.*;

public class SymbolTable {

	private ArrayList<Hashtable<String, BasicType>> levels;
	private int actualLevel;

	public SymbolTable() {
		this.actualLevel = 0;
		this.levels = new ArrayList<Hashtable<String, BasicType>>();
		levels.add(actualLevel, new Hashtable<String, BasicType>());
	}

	public void openLevel() {
		// TODO Auto-generated method stub
		this.actualLevel++;
		levels.add(actualLevel, new Hashtable<String, BasicType>());
	}

	// Erase a level in the symbol table
	public void eraseLevel() {
		// TODO Auto-generated method stub
		levels.remove(actualLevel);
		this.actualLevel--;
	}

	// Search in the actual level
	public BasicType localSearch(String name) {
		return levels.get(actualLevel).get(name);
	}

	// Search in all the symbol table
	public BasicType totalSearch(String name) {
		int level = actualLevel;
		BasicType totalSearchResult = null;
		while (level >= 0 && totalSearchResult == null) {
			totalSearchResult = levels.get(level).get(name);
			level--;
		}
		return totalSearchResult;
	}
	
	public boolean has(String id){
		return (totalSearch(id) != null);	
	}
	
	public boolean has(BasicType id){
		return (totalSearch(id.getName()) != null);
			
	}
	
	public void add(BasicType bt){
		levels.get(actualLevel).put(bt.getName(),bt);
	}
}
