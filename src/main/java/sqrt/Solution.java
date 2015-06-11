package sqrt;

public class Solution {

	public static void main(String [] args) {
		System.out.println(new Solution().mySqrt(2147395599));
	}
	
	public int mySqrt(int x) {
		if(x == 1 || x== 0) {
			return x;
		}
		
		long start = 1;
		long end = x;
		while(start + 1 < end) {
			long mid = start + (end - start)/2;
			long midmid = mid * mid;
			if(midmid == x) {
				return (int)mid;
			} else if(midmid < x){
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return (int)start;
	}
}
