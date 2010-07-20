package pascalGO.error;


import pascalGO.types.BasicType;

/**
 * State class, used to store the information regarding a specific part of the code that need to be checked.
 * @author gonzalo
 *
 */
public class State {
	
	/**
	 * True if the element exists
	 */
	private boolean exists;
	
	/**
	 * True if the element already exists
	 */
	private boolean duplicate;
	
	/**
	 * 
	 */
	private BasicType type;
	
	
	/**
	 * Creates a new State given the token and the type, wic are the very minimal information needed.
	 * @param type Is the type of the Token.
	 */
	public State(BasicType type){
		this.type = type;
	}
	
	/**
	 * Parameterized Constructor, creates a new State with the type and tokens and the values of the checks.
	 * @param exists parameter, exists state
	 * @param duplicate
	 */
	public State (BasicType type,boolean exists, boolean duplicate){
		this.type = type;
		this.exists = exists;
		this.duplicate = duplicate;
	}

	public BasicType getType() {
		return type;
	}

	public void setType(BasicType type) {
		this.type = type;
	}
	
	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	public boolean isDuplicate() {
		return duplicate;
	}

	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}

}
