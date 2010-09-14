package pascalGO.types;

import java.util.ArrayList;
import java.util.Hashtable;

public class Procedure extends BasicType{

	private Hashtable<String, Variable> parameters;
	private ArrayList<String> indexHashtable;
	
	public Procedure (String name){
		super(name);
		parameters = new Hashtable<String, Variable>();
		indexHashtable = new ArrayList<String>();
	}

	public void addVariable(Variable parameter){
		indexHashtable.add(parameter.getName());
		parameters.put(parameter.getName(), parameter);
	}
	
	public Variable getVariable(String name){
		return parameters.get(name);
	}
	
	public Variable getVariable(int index){
		return parameters.get(indexHashtable.get(index));
	}
	
	public ArrayList<Variable> getParameters(){
		return new ArrayList<Variable>(this.parameters.values());
	}
	
	public void merge (ArrayList <Variable> params){
		for (Variable parameter : params){
			indexHashtable.add(parameter.getName());
			parameters.put(parameter.getName(), parameter);
			
		}
	}
	
	public String getType(int index){
		return parameters.get(indexHashtable.get(index)).getType();
	}
}
