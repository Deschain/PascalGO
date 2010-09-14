package pascalGO.types;

import java.util.ArrayList;

public class RecordType extends Type{
	
	private ArrayList<Variable> variables;
	
	public RecordType(){
		super();
	}
	
	public RecordType(String name){
		super(name);
	}
	
	public void addVariable(Variable var){
		this.variables.add(var);
	}
	
	public Variable getVariable(int index){
		return this.variables.get(index);
	}

	public void setVariables(ArrayList<Variable> v){
		variables = v;
	}
	
	public void merge (ArrayList<Variable> v){
		variables.addAll(v);
	}
	
	public Variable getVariable (String name){
		for (Variable v: variables)
			if (v.getName().equals(name))
				return v;
		return null;
	}
}
