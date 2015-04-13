package maximun.subarray;

public class Solution {

	public static void main(String [] args) {
		int A [] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Solution().maxSubArray(A));
	}
	
	public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) {
        	return 0;
        }
        if(A.length == 1) {
        	return A[0];
        }
        
        int dp = A[0];
        int max = dp;
        for(int i=1; i<A.length; i++) {
        	dp = Math.max(A[i], dp+A[i]);
        	max = Math.max(dp, max);
        }
        return max;
    }
}
