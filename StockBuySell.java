import java.util.ArrayList;
import java.util.List;

class stocks{
	int buy,sell;
}

public class StockBuySell {

	
	
	
	public static void main(String[] args) {
        StockBuySell stock = new StockBuySell();
        
        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;
 
        // fucntion call
        stock.stockBuySell(price, n);
	}

	private void stockBuySell(int[] price, int n) {
		
		if(n==1){
			return;
		}
		
		int count = 0;
		
		List<stocks> stocks = new ArrayList<stocks>();
		
		int i = 0;
		while(i<n-1){
			
			while(i<n-1 && price[i] >= price[i+1]){
				i++;
			}
			
			if(i==n-1){
				break;
			}
			
			stocks stock = new stocks();
			stock.buy = i++;
			
			
			while(i<n && price[i-1] <= price[i]){
				i++;
			}
			
			stock.sell = i-1;
			
			stocks.add(stock);
			
			count++;
		}
		
		for( i =0 ; i< count ; i++){
			
			System.out.println("BUY On: " + stocks.get(i).buy  + " Day, SELL On: " + stocks.get(i).sell + " Day");
			
		}
	}
}
