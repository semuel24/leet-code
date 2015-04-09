package climbing.stairs;

public class Solution {

	public static void main(String [] args) {
		System.out.println(new Solution().climbStairs(3));
		System.out.println(new Solution().climbStairs(4));
		System.out.println(new Solution().climbStairs(5));
	}
	
	public int climbStairs(int n) {
		if(n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		//n>=3 dp[i]=dp[i-1]+dp[i-2]
		int i=1, j=2, k=0, index=3;
		while(index<=n) {
			k=i+j;
			i=j;
			j=k;
			index++;
		}
		return k;
	}
}
