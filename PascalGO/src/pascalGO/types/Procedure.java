package pascalGO.types;

public class Procedure extends BasicType{

	public static final String PROCEDURE = "procedure";
	
	//Atributo de la clase que sea la lista de parametros
	
	public  Procedure (String name){
		super.setName(name);
		super.setType(PROCEDURE);
	}
	
	
	
}
