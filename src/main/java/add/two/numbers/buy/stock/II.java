package buy.stock;

public class II {

	public static void main(String[] args) {

		int[] data = {30,30,29,50,18,1,2};
		II ii = new II();
		Solution s = ii.new Solution();
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
	    	
	    	int maxProfit = 0;
	    	for(int i=1; i<prices.length; i++) {
	    		if(prices[i]- prices[i-1] > 0) {
	    			maxProfit += prices[i]- prices[i-1];
	    		}
	    	}
	    	
	    	return maxProfit;
	    }
	}
}
