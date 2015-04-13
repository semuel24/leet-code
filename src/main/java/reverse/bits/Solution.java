package reverse.bits;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().reverseBits(43261596));
	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int reverse = 0, index = 0;

		while (index < 32) {
			int tmp = 1 & n;
			reverse <<= 1;
			reverse += tmp;
			n >>= 1;
			index ++;
		}
		return reverse;
	}
}
