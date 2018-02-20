import java.util.Arrays;

public class Stack {

	private String[] stackArray;
	
	private int stackSize;
	
	private int topStack = -1;
	
	
	 Stack(int size){
		 stackSize = size;
		 stackArray = new String[size];
		 
		 Arrays.fill(stackArray, "-1");
	}
	 
	 public void push(String input){
		 
		 if(topStack + 1 < stackSize){
			 topStack++;
			 stackArray[topStack] = input;
		 }else{
			 System.out.println("Sorry Stack is full");
		 }
	 }
	 
	 
	 public void pop(){
		 if(topStack  >= 0){
			 System.out.println("Removed element" + stackArray[topStack]);
			 stackArray[topStack] = "-1";
		 }else{
			 System.out.println("Stack is Empty");
		 }
	 }
	 
	 public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push("ds");
		stack.push("sda");
		stack.push("fsa");
		stack.push("fsd");
		stack.push("da");
		
		System.out.println(stack.toString());
		stack.push("dsa");
	}

	@Override
	public String toString() {
		return "Stack [stackArray=" + Arrays.toString(stackArray) + ", stackSize=" + stackSize + ", topStack="
				+ topStack + "]";
	}
}
