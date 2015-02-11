package one.plue;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author yaoxu
 * 
 */
//[7,2,3]
public class Solution {

	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) {
			int [] _a = {1};
			return _a;
		}
		
		int carry = 1;
		for(int i=digits.length-1; i>=0; i--) {
			int sum = digits[i] + carry;
			carry = sum / 10;
			digits[i] = sum % 10;
		}
		
		if(carry > 0) {
			int [] _a = new int[digits.length + 1];
			_a[0] = carry;
			for(int i=1; i< _a.length; i++) {
				_a[i] = digits[i-1];
			}
			return _a;
		} else {
			return digits;
		}
	}
	
	public static void main(String [] args) {
		Solution s = new Solution();
		int [] a = {7,2,3};
		s.plusOne(a);
	}
}
