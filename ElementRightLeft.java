import java.util.Arrays;
import java.util.Scanner;

public class ElementRightLeft {

    
    private void compute(int[] array)
    {
       boolean right[] = new boolean[array.length];
        
       Arrays.fill(right,true);
       
       int leftMax=array[0],rightMin=array[array.length-1];
       
       
       for(int i=array.length-2;i>-1;--i)
       {
           if(array[i] < rightMin)
           {
               rightMin = array[i];
           }
           else
           {
               right[i] = false;
           }
       }
     System.out.println("The elements satisfying the condition are - ");
     
       for(int i=0;i<array.length;++i)
       {
           if(i==0 && right[i])
               System.out.println(array[i]);
           else if(right[i] && array[i] > leftMax)
               System.out.println(array[i]);
           else if(array[i] > leftMax)
           {
               leftMax = array[i];
           }
       }
       
    }
    

    private static int[] input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Array");
        
        int n = Integer.parseInt(sc.nextLine());
        
        int[] array = new int[n];
        
        System.out.println("Enter the Elements");
        
        for(int i=0;i<array.length;++i)
            array[i] = Integer.parseInt(sc.next());
        
        return array;
    }
    
    public static void main(String[] args) {      
        
    new ElementRightLeft().compute(input());
        
   
}   
	
}
