package pascalGO.types;

public class Variable extends BasicType {

	private String type;
	private String access;

	public Variable (String name){
		super(name);
		this.access = null;
	}
	
	public Variable(String name, String type){
		super(name);
		this.type = type;
		this.access = null;
	}
	
	public Variable(String name, String type, String access){
		super(name);
		this.type = type;
		this.access = access;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
}
