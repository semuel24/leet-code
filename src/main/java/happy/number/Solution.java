package happy.number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String [] args) {
		System.out.println(new Solution().isHappy(19));
	}
	
	public boolean isHappy(int n) {
		Set<Integer> numbers = new HashSet<Integer>();
		
		do {
			numbers.add(n);
			n = squareAdd(n);
			if (n == 1) {
				return true;
			}
		} while (!numbers.contains(n));
		
		return false;
	}
	
	private int squareAdd(int n) {
		int sum = 0;
		while(n>0) {
			int d = n%10;
			sum += d*d;
			n /= 10;
		}
		return sum;
	}
}
