package pascalGO.grammar;

public class IntermediateCodeGenerator implements PascalGOVisitor {
	
	/**
	 * Number of the current temporal register
	 */
	private int tempReg = 0;
	
	/**
	 * Number of the current conditional label
	 */
	
	private int ifLabel = 0;
	
	/**
	 * Number of the current loop label
	 */
	
	private int whileLabel = 0;
	
	/**
	 * Obtains the number of the register to store intermediate values
	 *  
	 * @return The number of the current temporal register
	 */
	private int getTemporalReg() {	
		 int aux = tempReg;
		 tempReg++;
		 return aux;
	}
	
	/**
	 * Obtains the number of the current label for conditional instructions
	 * 
	 * @return The number of the current label
	 */
	private String getIfLabel(){
		int numLabel = ifLabel;
		ifLabel++;
		return "IF"+numLabel;
	}	
	
	/**
	 * Obtains the number of the current label for loop instructions
	 * 
	 * @return The number of the current label
	 */
	private String getWhileLabel(){
		int numLabel = whileLabel;
		whileLabel++;
		return "LP"+numLabel;
	}
	
	private void printResult(String result){
		System.out.println("     "+result);	
	}
	
	/**
	 * Process a SimpleNode
	 *  
	 * @param node The current node
	 */
	public Object visit(SimpleNode node, Object data) {
		String result;
		/* Process all the children of the node */
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode) node.jjtGetChild(i);
			String label;
			if(child instanceof NodeProcedure){
				/* Include the procedure label */
				label = ((String) child.jjtGetValue()).toUpperCase();
				System.out.println(label);
			}else if(child instanceof NodeBlock){
				/* Include the main label */
				label = "MAIN";
				System.out.println(label);
			}			
			child.jjtAccept(this, null);
		}
		result = "(END)";		
		printResult(result);
		return null;
	}

	
	public Object visit(NodePrograma node, Object data) {
		return null;
	}
	
	/**
	 * Process a SimpleNode
	 *  
	 * @param node The current node
	 */
	public Object visit(NodeBlock node, Object data) {
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return null;
	}

	/**
	 * Process a NodeProcedure
	 *  
	 * @param node The current procedure node
	 */
	public Object visit(NodeProcedure node, Object data) {
		for(int i=0;i<node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		printResult("(RET)");
		return null;
	}

	/**
	 * Process a NodeAsignment
	 *  
	 * @param node The current assignment node
	 */
	public Object visit(NodeAsignement node, Object data) {
		int numChilds = node.jjtGetNumChildren();
		if(numChilds==2){
			/* The current assignment node is a store into a variable */
			String result = "(STR";		
			for (int i = 0; i < node.jjtGetNumChildren(); i++) {
				result += "," + node.jjtGetChild(i).jjtAccept(this, null);
			}
			result += ")";
			printResult(result);				
			return null;	
		}else{
			/* The current assignment node is a call to a procedure */
			String result = "(CALL,";
			result += node.jjtGetChild(0).jjtAccept(this, null);
			result += ")";
			printResult(result);
			return null;
		}
		
	}

	/**
	 * Process a NodeConditional
	 *  
	 * @param node The current conditional node
	 */
	public Object visit(NodeConditional node, Object data) {
		String result;
		String label = getIfLabel();
		String label2= getIfLabel();
		result = "(BCN";
		int numChilds = node.jjtGetNumChildren();
		result += ","+node.jjtGetChild(0).jjtAccept(this, null);
		result += ","+label+")";
		printResult(result);
		if(numChilds == 2){
			/* Conditional node without else part */
			node.jjtGetChild(1).jjtAccept(this, null);
			System.out.println(label);
		}else{
			/* Conditional node with else part */
			node.jjtGetChild(1).jjtAccept(this, null);
			printResult("(BCH,"+label2+")");
			System.out.println(label);
			node.jjtGetChild(2).jjtAccept(this, null);
			System.out.println(label2);
		}
		return null;
	}

	/**
	 * Process a NodeLoop
	 *  
	 * @param node The current while node
	 */
	public Object visit(NodeLoop node, Object data) {
		String result;
		String startLabel = getWhileLabel();
		String endLabel = getWhileLabel();
		System.out.println(startLabel);
		result = "(BCN";
		result += ","+node.jjtGetChild(0).jjtAccept(this, null);
		result += ","+endLabel+")";						
		printResult(result);		
		for(int i=1; i<node.jjtGetNumChildren();i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		printResult("(BCH,"+startLabel+")");
		System.out.println(endLabel);
		return null;
	}

	/**
	 * Process a NodeopRel
	 *  
	 * @param node The current relational operation node
	 * @return The temporal register where the result will be stored
	 */
	public Object visit(NodeopRel node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "(" + node.jjtGetValue();
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += "," + node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",R" + temporalReg + ")";
		printResult(result);		
		return "R"+temporalReg;
	}

	/**
	 * Process a NodeopAdt
	 *  
	 * @param node The current additive operation node
	 * @return The temporal register where the result will be stored
	 */
	public Object visit(NodeopAdt node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "(" + node.jjtGetValue();
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += "," + node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",R" + temporalReg + ")";
		printResult(result);		
		return "R"+temporalReg;
	}

	/**
	 * Process a NodeopMul
	 *  
	 * @param node The current multiplication operation node
	 * @return The temporal register where the result will be stored
	 */
	public Object visit(NodeopMul node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "(" + node.jjtGetValue();
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += "," + node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",R" + temporalReg + ")";
		printResult(result);
		return "R"+temporalReg;
	}

	/**
	 * Process a NodeConstant
	 *  
	 * @param node The current constant node
	 * @return The value of the node
	 */
	public Object visit(NodeConstant node, Object data) {
		return node.jjtGetValue();
	}

	/**
	 * Process a NodeSigno
	 *  
	 * @param node The current sign node
	 * @return The temporal register where the result will be stored
	 */
	public Object visit(NodeSigno node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "(*,"+node.jjtGetValue()+"1";
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += "," + node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",R" + temporalReg + ")";
		printResult(result);
		return "R"+temporalReg;
	}

	/**
	 * Process a NodeSelector
	 *  
	 * @param node The current selector node
	 * @return The access to the compound variable
	 */
	public Object visit(NodeSelector node, Object data) {
		String result;
		if (node.jjtGetValue() instanceof String) {
			/* Current selector node is a field of a record */
			result = "." + node.jjtGetValue();
		} else {
			/* Current selector node is a position in some array */
			SimpleNode selector = (SimpleNode) node.jjtGetValue();
			result = "[" + (String) selector.jjtAccept(this, null) + "]";
		}
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += node.jjtGetChild(i).jjtAccept(this, null);
		}
		return result;
	}

	/**
	 * Process a NodeIdentifier
	 *  
	 * @param node The current identifier node
	 * @return The identifier and its access if it is a compound variable
	 */
	public Object visit(NodeIdentifier node, Object data) {
		String result;
		result = (String) node.jjtGetValue();
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += node.jjtGetChild(i).jjtAccept(this, null);
		}
		return result;
	}

}