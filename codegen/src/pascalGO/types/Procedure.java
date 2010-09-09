package pascalGO.types;

import java.util.Hashtable;

public class Procedure extends BasicType{

	private String name;
	private Hashtable<String, Variable> parameters;
	
	public Procedure (String name){
		super();
		this.name = name;
		parameters = new Hashtable<String, Variable>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addVariable(Variable parameter){
		parameters.put(parameter.getName(), parameter);
	}
	
	public Variable getVariable(String name){
		return parameters.get(name);
	}
	
	public Variable getVariable(int index){
		return (Variable) parameters.values().toArray()[index];
	}
}
