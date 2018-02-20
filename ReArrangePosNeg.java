
public class ReArrangePosNeg {



	private static void rearrange(int[] arr, int n) {
				
			int i = -1;
			int temp = 0;
			
			for(int j=0; j<n; j++){
				if(arr[j] < 0){
					i++;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
			
	}
	static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr,n);
        System.out.println("Array after rearranging: ");
        printArray(arr,n);
    }
}
