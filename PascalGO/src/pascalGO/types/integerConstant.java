package pascalGO.types;

public class integerConstant extends BasicType{
	
	private int value;
	private char signo;
	
	public integerConstant(String name, int value, char signo){
		super.setName(name);
		this.value = value;
		this.signo = signo;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getSigno() {
		return signo;
	}

	public void setSigno(char signo) {
		this.signo = signo;
	}
	

}
