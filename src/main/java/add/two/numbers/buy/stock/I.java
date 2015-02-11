package buy.stock;

public class I {

	public static void main(String [] args) {
		
		int[] data = {30,30,29,50,18,1,2,80,6,7};
		I i = new I();
		Solution s = i.new Solution();
		System.out.println("The max profit can be: " + s.maxProfit(data));
	}
	
	public class Solution {
	    public int maxProfit(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	    	if(prices == null) {
	    		return 0;
	    	} else if(prices.length == 0) {
	    		return 0;
	    	}
	 
	    	int lowest = Integer.MAX_VALUE;
	    	int maxProfit = Integer.MIN_VALUE;
	    	
	    	for(int i=0; i<prices.length; i++) {
	    		if(prices[i] < lowest) {
	    			lowest = prices[i];
	    		}
	    		
	    		//calculate today's max profit
	    		int todayProfit = prices[i] - lowest;
	    		if(todayProfit > maxProfit) {
	    			maxProfit = todayProfit;
	    		}
	    	}
	    	
	    	return maxProfit;
	    }
	}
}
