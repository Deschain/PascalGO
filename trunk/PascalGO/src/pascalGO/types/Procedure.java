package pascalGO.types;

import java.util.ArrayList;

import pascalGO.grammar.Token;

public class Procedure extends BasicType{

	ArrayList<ListVar> parameters = null;
	
	public  Procedure (Token token){
		super(token);
		parameters = new ArrayList<ListVar>();
	}
	
	public Procedure (Token token, ArrayList<ListVar> parameters){
		super(token);
		this.parameters = parameters;
	}
	
	public void setParameters (ArrayList<ListVar> parameters){
		this.parameters = parameters;
	}
	
	public ArrayList<ListVar> getParameters(){
		return parameters;
	}
	
	public void add(ListVar list){
		parameters.add(list);
	}
	
	
	
}
