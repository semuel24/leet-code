package palindrome.number;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author yaoxu
 * 
 */
public class Solution {

	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome(-2147447412));
	}
	
	public boolean isPalindrome(int x) {
		
		if(x<0) {
			return false;
		}
		
		int result = x, length = 1;
		while(result/10 != 0) {
			result = result/10;
			length ++;
		}
		
		if(length == 1) {
			return true;
		}
		
		//123
		int i=length, j=1;
		while(i>=j) {
			int highBit = (x/power(10, i-1))%10;
			int lowBit = (x/power(10, j-1))%10;
			if(highBit != lowBit) {
				return false;
			}
			i--;
			j++;
		}
		return true;
	}
	
	private int power(int base, int time) {
		int total = 1;
		while(time>0) {
			total *= base;
			time--;
		}
		return total;
	}
}
