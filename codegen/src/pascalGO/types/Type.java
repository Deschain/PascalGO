package pascalGO.types;

import pascalGO.types.BasicType;

public class Type extends BasicType {

	//Nothing, just superclass for Type definition
	
	public Type (){
		super();
	}
	
	public Type (String name){
		super(name);
	}
	
	public boolean equals(Type t){
		return this.getName().toLowerCase().equals(t.getName().toLowerCase());
	}
}
