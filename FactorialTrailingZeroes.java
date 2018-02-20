
public class FactorialTrailingZeroes {

	private void TrailingZeroes(int n){
		int count = 0;
			
			while(n>0)
			{
			count+=n/5;
			n=n/5;
			}
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		
		FactorialTrailingZeroes fact = new FactorialTrailingZeroes();
		
		fact.TrailingZeroes(5);
		
	}
}
