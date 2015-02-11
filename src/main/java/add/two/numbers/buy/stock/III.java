package buy.stock;

public class III {

	public static void main(String[] args) {
		int[] data = {2,1,2,0,1};
		III iii = new III();
		Solution1 s1 = iii.new Solution1();
		System.out.println("Solution1 max profit is: " + s1.maxProfit(data));
		
		Solution2 s2 = iii.new Solution2();
		System.out.println("Solution2 max profit is: " + s2.maxProfit(data));
	}
	
	//O(n^2)
	public class Solution1 {
		//find max profit by 2 buys
	    public int maxProfit(int[] prices) {
	    
	    	int maxProfit = Integer.MIN_VALUE;
//	    	int index = Integer.MIN_VALUE;
//	    	int maxProfitBySomeDay = Integer.MIN_VALUE;
//	    	int maxProfitAfterSomeDay = Integer.MIN_VALUE;
	    	for(int i=0; i<prices.length; i++) {
	    		int _maxProfitBySomeDay = maxProfit(prices, 0, i);
	    		int _maxProfitAfterSomeDay = maxProfit(prices, i, prices.length);
	    		int todayMaxProfit = _maxProfitBySomeDay + _maxProfitAfterSomeDay;
	    		if(todayMaxProfit > maxProfit) {
	    			maxProfit = todayMaxProfit;
//	    			index = i;
//	    			maxProfitBySomeDay = _maxProfitBySomeDay;
//	    			maxProfitAfterSomeDay = _maxProfitAfterSomeDay;
	    		}
	    	}
//	    	System.out.println("Solution1 max profit index is: " + index);
//	    	System.out.println("Solution1 before index max profit is: " + maxProfitBySomeDay);
//	    	System.out.println("Solution1 after index max profit is: " + maxProfitAfterSomeDay);
	    	return maxProfit;
	    }
	    
	    //find max profit by one buy, specifying start and end index of input array
	    private int maxProfit(int[] prices, int _startIndex, int _endIndexExclusive) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	    	if(prices == null) {
	    		return 0;
	    	} else if(prices.length == 0) {
	    		return 0;
	    	} else if(_startIndex > _endIndexExclusive || _startIndex == _endIndexExclusive) {
	    		return 0;
	    	}
	 
	    	int lowest = Integer.MAX_VALUE;
	    	int maxProfit = Integer.MIN_VALUE;
	    	
	    	for(int i=_startIndex; i<_endIndexExclusive; i++) {
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
	
	//O(n)
	public class Solution2 {
		
		public int maxProfit(int[] prices) {
			
			if(prices == null) {
	    		return 0;
	    	} else if(prices.length == 0) {
	    		return 0;
	    	}
			
			int length = prices.length;
			int[] maxProfitBySomeDay = new int[length];
			int[] maxProfitAfterSomeDay = new int[length];
			
			//populate maxProfitBySomeDay[]
			int lowest = Integer.MAX_VALUE;
			for(int i=0; i<length; i++) {
				if(prices[i] < lowest) {
					lowest = prices[i];
				}
				
				if(i==0){
					maxProfitBySomeDay[i] = 0;
				}else {
					maxProfitBySomeDay[i] = prices[i] - lowest;
					if(maxProfitBySomeDay[i] < maxProfitBySomeDay[i-1]) {
						maxProfitBySomeDay[i] = maxProfitBySomeDay[i-1];
					}
				}
			}
			System.out.println("printing maxProfitBySomeDay...");
			print(maxProfitBySomeDay);
			
			//populate maxProfitAfterSomeDay[]
			int highest = Integer.MIN_VALUE;
			for(int i=length-1; i>-1; i--) {
				if(prices[i] > highest) {
					highest = prices[i];
				}
				
				maxProfitAfterSomeDay[i] = highest - prices[i];
			}
			System.out.println("printing maxProfitAfterSomeDay...");
			print(maxProfitAfterSomeDay);
			
			//find max profit
			int maxProfit = Integer.MIN_VALUE;
			for(int i=0; i<length; i++) {
				if(maxProfitBySomeDay[i] + maxProfitAfterSomeDay[i] > maxProfit) {
					maxProfit = maxProfitBySomeDay[i] + maxProfitAfterSomeDay[i];
				}
			}
			
			return maxProfit;
		}
		
		private void print(int[] _data) {
			if(_data == null) {
				return;
			}
			
			for(int i=0; i<_data.length; i++) {
				System.out.printf("%9d", _data[i]);
			}
			System.out.println("");
		}
	}
}
