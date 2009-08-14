package pascalGO.types;

public class logicConstant extends BasicType{

	private boolean value;
	
	public logicConstant(String name, boolean value){
		super.setName(name);
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
