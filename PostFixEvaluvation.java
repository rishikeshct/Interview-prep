import java.util.Stack;

public class PostFixEvaluvation {

	private void evaluvate(String exp){
		 
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<exp.length(); i++){
			
			char ch = exp.charAt(i);
			
			if(Character.isDigit(ch)){
				stack.push(ch - '0');
			}
			else{
				
				int value1 = stack.pop();
				int value2 = stack.pop();
				
				switch(ch){
				
					case '+' : stack.push(value1+value2);
								break;
					case '-' :  stack.push(value2-value1);
								break;
					case '*' : stack.push(value1 * value2);
								break;
					case '/' : stack.push(value2/value1);
								break;
					default : System.out.println("not a valid operator");
								
				}
				
			}
		}
		
		System.out.println("Answer : " + stack.peek());
	}
	
	public static void main(String[] args) {
		
		PostFixEvaluvation post = new PostFixEvaluvation();
		
		String exp="231*+9-";
		post.evaluvate(exp);
	}
}
