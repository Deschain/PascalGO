package pascalGO.types;

public class BasicType {

	private String name;
	private boolean used = false;
	
	public BasicType(){
		name = null;	
		this.used = false;
	}
	
	public BasicType(String name){
		this.name = name;
		this.used = false;
	}
	
	public String getName(){
		return this.name.toLowerCase();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void use(){
		this.used = true;
	}
	
	public boolean isUsed(){
		return this.used;
	}

}
