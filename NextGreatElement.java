
public class NextGreatElement {

	public static void main(String[] args) {
		
		int[] array = new int[]{11,8,9,4,5};
		int n = array.length;
		int max = array[n-1];
		
		for(int i=n-2;i>=0;i--){
			
			if(array[i]>max){
				max = array[i];
			}else{
				array[i] = max;
			}
			
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
