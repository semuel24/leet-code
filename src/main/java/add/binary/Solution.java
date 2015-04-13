package add.binary;

public class Solution {

	public static void main(String[] args) {
		 System.out.println(new Solution().addBinary("1", "111"));
		System.out.println(new Solution().addBinary("1010", "1011"));
		System.out.println(new Solution().addBinary("0", "0"));
	}	
	
	public String addBinary(String a, String b) {

		if (a == null || b == null) {
			return null;
		}

		int length = a.length() > b.length() ? a.length() : b.length();
		int alength = a.length();
		int blength = b.length();
		char[] sumChar = new char[length+1];
		int carry = 0;
		//
		for (int i = 0; i <= length; i++) {
			int thePosition = 0;
			if (alength - 1 - i >= 0) {
				thePosition += Character.getNumericValue(a.charAt(alength - 1
						- i));
			}
			if (blength - 1 - i >= 0) {
				thePosition += Character.getNumericValue(b.charAt(blength - 1
						- i));
			}
			if (carry == 1) {
				thePosition += carry;
			}
			if (thePosition == 0 || thePosition == 1) {
				carry = 0;
				sumChar[length - i] = thePosition == 0 ? '0' : '1';
			} else if (thePosition == 2) {
				sumChar[length - i] = '0';
				carry = 1;
			} else if (thePosition == 3) {
				sumChar[length - i] = '1';
				carry = 1;
			} else {
				throw new RuntimeException("");
			}
		}
		// fix head
		String sumStr = new String(sumChar);
		sumStr = sumStr.charAt(0)=='0'?sumStr.substring(1):sumStr;
		return sumStr;
	}
}
