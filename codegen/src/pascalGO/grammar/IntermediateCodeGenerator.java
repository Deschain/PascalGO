package pascalGO.grammar;

public class IntermediateCodeGenerator implements PascalGOVisitor {

	private int tempReg = 0;
	private int ifLabel = 0;
	private int whileLabel = 0;
	
	private int getTemporalReg() {	
		 int aux = tempReg;
		 tempReg++;
		 return aux;
	}
	
	private String getIfLabel(){
		int numLabel = ifLabel;
		ifLabel++;
		return "IF"+numLabel;
	}
	
	private String getWhileLabel(){
		int numLabel = whileLabel;
		whileLabel++;
		return "LP"+numLabel;
	}
	
	private void printResult(String result){
		System.out.println("     "+result);	
	}
	
	@Override
	public Object visit(SimpleNode node, Object data) {
		String result;
		result = "(END)";
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		printResult(result);
		return null;
	}

	@Override
	public Object visit(NodePrograma node, Object data) {
		String result;
		result = "(END)";
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		printResult(result);
		return null;
	}
	
	@Override
	public Object visit(NodeBlock node, Object data) {
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(NodeProcedure node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NodeAsignement node, Object data) {		
		String result = "(str";		
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += "," + node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ")";
		printResult(result);				
		return null;
	}

	@Override
	public Object visit(NodeConditional node, Object data) {
		String result;
		String label = getIfLabel();
		result = "(BCN";
		int numChilds = node.jjtGetNumChildren();
		result += ","+node.jjtGetChild(0).jjtAccept(this, null);
		result += ","+label+")";
		printResult(result);
		if(numChilds == 2){
			node.jjtGetChild(1).jjtAccept(this, null);
			System.out.println(label);
		}else{
			//Else branch
			node.jjtGetChild(1).jjtAccept(this, null);
			System.out.println(label);
			node.jjtGetChild(2).jjtAccept(this, null);
		}
		return null;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
	public Object visit(NodeConstant node, Object data) {
		return node.jjtGetValue();
	}

	@Override
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

	@Override
	public Object visit(NodeSelector node, Object data) {
		String result;
		if (node.jjtGetValue() instanceof String) {
			result = "." + node.jjtGetValue();
		} else {
			SimpleNode selector = (SimpleNode) node.jjtGetValue();
			result = "[" + (String) selector.jjtAccept(this, null) + "]";
		}
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += node.jjtGetChild(i).jjtAccept(this, null);
		}
		return result;
	}

	@Override
	public Object visit(NodeIdentifier node, Object data) {
		String result;
		result = (String) node.jjtGetValue();
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			result += node.jjtGetChild(i).jjtAccept(this, null);
		}
		return result;
	}

}
