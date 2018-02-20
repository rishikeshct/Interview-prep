
public class Fib {
	
	public static void main(String[] args) {
		Fib f = new Fib();
		System.out.println(f.fib(4));
		
	}
	
	
	private int fib(int n){
		if(n <= 1){
			return n;
		}
		
		return fib(n-1) + fib(n-2) ;
	}
}
