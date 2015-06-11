package maximum.product.subarray;

public class Solution {

	public static void main(String [] args) {
//		int A [] = {2,3,-2,4};
//		int A [] = {-4,-3,-2};
		int A [] = {-2,3,-4};
//		int A [] = {1,-2,3,-2,4};
		System.out.println(new Solution().maxProduct(A));
	}
	
	public int maxProduct(int[] A) {
        int max = A[0], min = A[0];
        int product = A[0];
        
        for(int i=1; i<A.length; i++) {
        	int lastmax = max;
        	int lastmin = min;
        	max = Math.max(A[i], Math.max(A[i]*lastmax, A[i]*lastmin));
        	min = Math.min(A[i], Math.min(A[i]*lastmax, A[i]*lastmin));
        	product = Math.max(max, product);
        }
        
        return product;
    }
}
