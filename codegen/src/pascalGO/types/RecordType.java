package pascalGO.types;

import java.util.List;

public class RecordType extends BasicType{

	private String name;
	private List<Variable> variables;
	
	public RecordType(String name){
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addVariable(Variable var){
		this.variables.add(var);
	}
	
	public Variable getVariable(int index){
		return this.variables.get(index);
	}

}
