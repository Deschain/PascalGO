package pascalGO.grammar;


public class IntermediateCodeGenerator implements PascalGOVisitor{

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
		// TODO Auto-generated method stub
		for(int i=0; i<node.jjtGetNumChildren();i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
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
	public Object visit(NodeConstant node, Object data) {		
		return node.jjtGetValue();
	}

	@Override
	public Object visit(NodeopRel node, Object data) {
		String result;
		result = "("+node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ")";
		System.out.println(result);		
		return null;
	}

	@Override
	public Object visit(NodeopAdt node, Object data) {
		String result;
		result = "("+node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ")";
		System.out.println(result);
		return null;
	}

	@Override
	public Object visit(NodeopMul node, Object data) {
		String result;
		result = "("+node.jjtGetValue();
		for(int i = 0; i< node.jjtGetNumChildren(); i++){
			result += ","+node.jjtGetChild(i).jjtAccept(this, null);
		}
		result += ")";
		System.out.println(result);
		return null;
	}

	@Override
	public Object visit(NodeSigno node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NodeSelector node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NodeIdentifier node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NodeNegacion node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

}
