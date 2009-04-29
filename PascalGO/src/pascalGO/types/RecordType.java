package pascalGO.types;

import java.util.ArrayList;
import java.util.Iterator;

public class RecordType extends Variable{

	public static final String RECORD = "record";
	
	private ArrayList<Variable> variables = null;
	
	public RecordType(String name){
		super(name, RECORD);
	}
	
	public void addVariable (Variable variable){
		variables.add(variable);
	}
	
	public Variable getVariable(int index){
		return variables.get(index);
	}
	
	public Variable getVariable(String name){
		Iterator<Variable> aux = variables.iterator();
		while(aux.hasNext()){
			Variable auxVar = aux.next();
			if (auxVar.getName()== name){
				return auxVar; 
			}
		}
		return null;
	}
	
	public int getSize(){
		return variables.size();
	}
	
}
