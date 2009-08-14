package pascalGO.types;

public class Variable extends BasicType {
	
	private String type;
	private String access;

	public Variable(String name, String type, boolean access) {
		super.setName(name);
		this.type = type;
		if (access){
			this.access = new String("dir");
		}else{
			this.access = new String("ref");
		}
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
