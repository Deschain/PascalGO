package pascalGO.types;

public class Constant extends BasicType {

	private String value;
	private String type;
	
	public Constant(String name, String value){
		super(name);
		this.value = value;
		this.type = null;
	}
	
	public Constant(String name, String value,String type){
		super(name);
		this.value = value;
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
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
