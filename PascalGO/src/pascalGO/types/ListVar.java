package pascalGO.types;

import java.util.ArrayList;
import java.util.Iterator;

import pascalGO.grammar.*;

public class ListVar {
	
	private ArrayList<Variable> variables;
	private Type type;
	
	public ListVar() {
		variables = new ArrayList<Variable>();
		type = null;
	}
	
	public ListVar(ArrayList<Variable> variables,Type type){
		this.variables =variables;
		this.type = type;
	}
	
	public void add (Token token){
		variables.add(new Variable(token,null,false));
	}
	
	public void setType(Token token){
		this.type = new Type(token);
	    Iterator<Variable> itr = variables.iterator();
	    while (itr.hasNext()) {
	      Variable element = itr.next();
	      element.setType(this.type);
	    }
	}
	
	public void setAccess(boolean access){
		Iterator<Variable> itr = variables.iterator();
	    while (itr.hasNext()) {
	      Variable element = itr.next();
	      element.setAccess(access);
	    }
	}

}
