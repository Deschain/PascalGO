package pascalGO.types;

public class Variable extends BasicType {
	
	public static final String INT = "integer";
	public static final String BOOL = "boolean";
	
	private int value;

	public Variable(String name, String type) {
		super.setName(name);
		super.setType(type);
		
	}
	
	public void setValue(int value){
		this.value = value;
	}
	

	public int getValue(){
		return this.value;
	}
}
