package candy;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. 
 * Children with a higher rating get more candies than their neighbors. 
 * What is the minimum candies you must give?
 */
public class Solution {
	
	public static void main(String [] args) {
		int [] ratings = {7,5,3,0,0,1,4,6};
		Solution s = new Solution();
		System.out.println(s.candy(ratings));
	}
	
	public int candy(int[] ratings) {
		
		if(ratings == null) {
			return 0;
		}
		int _l = ratings.length;
		if( _l == 1) {
			return 1;
		}
		
		int candy[] = new int[_l];
		candy[0] = 1;
		
		//forwarding loop
		for(int i=1; i<_l; i++) {
			if(ratings[i]>ratings[i-1]) {
				candy[i] = candy[i-1] + 1;
			} else {
				candy[i] = 1;
			}
		}
		
		//backward loop
		for(int i=_l-2; i>=0; i--) {
			if(ratings[i] > ratings[i+1] && candy[i+1]+1 > candy[i] ) {
				candy[i] = candy[i+1] +1;
			}
		}
		
		int count = 0;
		for(int _count : candy) {
			System.out.print(_count + " ");
			count += _count;
		}
		return count;
	}
	
	
}