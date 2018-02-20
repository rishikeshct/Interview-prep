import java.util.Arrays;

public class Queue {

	private int queueSize;
	
	private int topQueue = -1;
	
	private int botomQueue = -1;

	private String[] queueArray;
	
	public Queue(int size) {

		queueSize = size;
		
		queueArray = new String[queueSize];
		
		Arrays.fill(queueArray, "-1");
	}
	
	public void push(String input){
	
		if(topQueue+1 <= queueSize){
			topQueue++;
			queueArray[topQueue] = input;
		}else{
			System.out.println("Sorry Queue is full");
		}
	}
	
	public void pop(){
		if(queueSize >= 0){
			botomQueue++;
			System.out.println("Removed Element" + queueArray[botomQueue]);
			queueArray[botomQueue] ="-1";
		}else{
			System.out.println("Queue is Empty");
		}
	}
	
	public static void main(String[] args) {
		
		Queue q = new Queue(2);
		
		q.push("3");
		q.push("fdsa");
		
		System.out.println(q.toString());
		
		q.pop();
	}

	@Override
	public String toString() {
		return "Queue [queueSize=" + queueSize + ", topQueue=" + topQueue + ", botomQueue=" + botomQueue
				+ ", queueArray=" + Arrays.toString(queueArray) + "]";
	}
}
