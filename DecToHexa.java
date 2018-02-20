
public class DecToHexa {

	private void decToHexa(int n){
		System.out.println("fsa");
		int temp;
		int i=0;
		 char[] hexaDeciNum = new char[100];
		while(n>0){
			
			temp = n%16;
			n=n/16;
			System.out.println(n);
			if(temp<10){
				hexaDeciNum[i] = (char) (temp + 48);
			}
			else if(temp<16){
				hexaDeciNum[i] = (char) (temp + 55);
			}
			
			i++;
		}
		
		for (int j = 0; j < hexaDeciNum.length; j++) {
				System.out.print(hexaDeciNum[j]);
		}
		
	}
	public static void main(String[] args) {
		
		DecToHexa d = new DecToHexa();
		
		d.decToHexa(2545);
	}
}
