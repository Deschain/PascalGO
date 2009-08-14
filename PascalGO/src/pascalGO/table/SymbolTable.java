package pascalGO.table;

import java.util.ArrayList;
import java.util.Hashtable;

import pascalGO.types.BasicType;

public class SymbolTable{

	private ArrayList<Hashtable<String, BasicType>> levels;
	private int actualLevel;
	
	public SymbolTable(){
		this.levels = new ArrayList<Hashtable<String,BasicType>>();
		this.actualLevel = 0;
	}
	
	public void openLevel() {
		// TODO Auto-generated method stub
		this.actualLevel ++;
		levels.add(actualLevel, new Hashtable<String, BasicType>());
	}
	
	//Erase a level in the symbol table
	public void eraseLevel() {
		// TODO Auto-generated method stub
		this.actualLevel --;
	}
	
	//Search in the actual level
	public BasicType localSearch(String name) {
		// TODO Auto-generated method stub
		return levels.get(actualLevel).get(name);
	}
	
	//Search in all the symbol table
	public Object totalSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object search() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insertName(BasicType name) {
		// TODO Auto-generated method stub
		levels.get(actualLevel).put(name.getName(), name);
		
	}
		
}
