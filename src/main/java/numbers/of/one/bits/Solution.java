package numbers.of.one.bits;

public class Solution {

	public static void main(String [] args) {
		System.out.println(new Solution().hammingWeight(11));
	}
	
	public int hammingWeight(int n) {
        int sum = 0;
        int index = 0;
        while(index < 32) {
        	int tmp = 1&n;
        	sum += tmp;
        	n= n >> 1;
        	index++;
        }
        return sum;
    }
}
