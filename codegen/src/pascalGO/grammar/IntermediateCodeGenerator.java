package pascalGO.grammar;

import java.util.ArrayList;


public class IntermediateCodeGenerator implements PascalGOVisitor{

	private int numTemporalReg = 10;
	private ArrayList<Boolean> temporalReg;	
	private int aux = 0;
	
	public IntermediateCodeGenerator(){
		temporalReg = new ArrayList<Boolean>();
		for(int i = 0; i < numTemporalReg;i++){
			temporalReg.add(true);
		}
	}
	
	private int getTemporalReg(){
		/*
		int temporalReg = 0;
		while(temporalReg<numTemporalReg){
			if(this.temporalReg.get(temporalReg) == true){
				this.temporalReg.set(temporalReg, false);
				return temporalReg;
			}else{
				temporalReg++;
			}
		}
		return -1;
		*/
		int result = aux;
		aux++;
		return result;
	}
	
	@Override
	public Object visit(SimpleNode node, Object data) {
		for(int i=0; i<node.jjtGetNumChildren();i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(NodePrograma node, Object data) {
		for(int i=0; i<node.jjtGetNumChildren();i++){
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
		String result = "(store";
		for(int i=0; i<node.jjtGetNumChildren();i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ")";
		System.out.println(result);
		return null;
	}

	@Override
	public Object visit(NodeConditional node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NodeLoop node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NodeopRel node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "("+node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",temp"+temporalReg+")";
		System.out.println(result);		
		this.temporalReg.set(temporalReg, true);
		return "temp"+temporalReg;
	}

	@Override
	public Object visit(NodeopAdt node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "("+node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",temp"+temporalReg+")";
		System.out.println(result);		
		this.temporalReg.set(temporalReg, true);
		return "temp"+temporalReg;
	}

	@Override
	public Object visit(NodeopMul node, Object data) {
		String result;
		int temporalReg = this.getTemporalReg();
		result = "("+node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ",temp"+temporalReg+")";
		System.out.println(result);
		this.temporalReg.set(temporalReg, true);
		return "temp"+temporalReg;
	}

	@Override
	public Object visit(NodeNegacion node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object visit(NodeConstant node, Object data) {		
		return node.jjtGetValue();
	}
	
	@Override
	public Object visit(NodeSigno node, Object data) {
		return null;
	}

	@Override
	public Object visit(NodeSelector node, Object data) {
		String result;
		if(node.jjtGetValue() instanceof String){
			result =  "."+node.jjtGetValue();
		}else{			
			SimpleNode selector = (SimpleNode) node.jjtGetValue();
			result = "["+(String) selector.jjtAccept(this, null)+"]";			
		}
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += node.jjtGetChild(i).jjtAccept(this, null);
		}
		return result;
	}

	@Override
	public Object visit(NodeIdentifier node, Object data) {
		String result;
		result = (String) node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += node.jjtGetChild(i).jjtAccept(this, null);
		}
		return result;
	}

}
