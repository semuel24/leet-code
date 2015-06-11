package bitwise.and.of.numbers.range;

public class Solution {

	public static void main(String [] args) {
//		System.out.println(new Solution().rangeBitwiseAnd(5, 7));
		System.out.println(new Solution().rangeBitwiseAnd(0, 2147483647));
	}
	
	public int rangeBitwiseAnd(int m, int n) {
        int result = m;
		for(int i=m+1; i<=n; i++) {
        		result &= i; 
        }
		return result;
    }
}
