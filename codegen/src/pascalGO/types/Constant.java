package pascalGO.types;

public class Constant extends BasicType {

	private String value;
	
	public Constant(String name, String value){
		super(name);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isNumeric(){
		try{
			Integer.parseInt(value);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}
}
