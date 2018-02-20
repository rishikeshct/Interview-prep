import java.util.HashSet;

public class FindLongestConseqSubseq {

	
	private int findLongestConseqSubseq(int arr[], int n){
		
			HashSet<Integer> hash = new HashSet<>();
			int ans = 0;
			
			for (int i = 0; i < arr.length; i++) {
				hash.add(arr[i]);
			}
			
			for (int i = 0; i < arr.length; i++) {
				if (!hash.contains(arr[i] - 1)) {
					System.out.println(arr[i]);
					int j = arr[i];
					while(hash.contains(j)){
						j++;
					}
					
					if (ans<j-arr[i])
						ans = j-arr[i];
				} 
			}
		return ans;
	}
	
	public static void main(String[] args) {
		
		FindLongestConseqSubseq f = new FindLongestConseqSubseq();
		int arr[] = {1, 9, 3, 10, 4, 20, 2,6,7 ,8,9,10};
		
		int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " + 
                           f.findLongestConseqSubseq(arr,n));
	}
}
