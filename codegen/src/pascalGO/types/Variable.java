package pascalGO.types;

public class Variable extends BasicType {

	private String name;
	private String access;

	public Variable (String name){
		super();
		this.name = name;
		this.access = null;
	}
	
	public Variable(String name, String type){
		super(type);
		this.name = name;
		this.access = null;
	}
	
	public Variable(String name, String type, String access){
		super(type);
		this.name = name;
		this.access = access;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
}
