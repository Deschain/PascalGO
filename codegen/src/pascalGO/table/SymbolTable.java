package pascalGO.table;

import java.util.ArrayList;
import java.util.Hashtable;

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

	public Object search() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(BasicType name) {
		// TODO Auto-generated method stub
		// Que busque antes de insertar y si encunetra algo igual que lance
		// excepcion
		if (check(name))
			levels.get(actualLevel).put(name.getName(), name);
		else {

		}
	}

	public boolean check(BasicType t) {
		if (t instanceof ArrayType) {

		}
		if (t instanceof Constant) {

		}
		if (t instanceof Variable) {

		}
		if (t instanceof Type) {
			return checkType((Type) t);
		}
		return false;
	}

	public boolean checkType(Type t) {
		if (totalSearch(t.getName()) != null)
			return true;
		else
			return false;
	}

	public boolean checkProcedure(Procedure p) {

		return true;
	}

}
