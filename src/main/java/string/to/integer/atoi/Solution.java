package string.to.integer.atoi;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * spoilers alert... click to show requirements for atoi.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author yaoxu
 * 
 */
public class Solution {
	
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.atoi("1"));
	}
	
	private static String MAX = "2147483647";
	private static String MIN = "2147483648";
	
	public int atoi(String str) {
		if(str == null) {
			return 0;
		}
		str = str.trim();
		if(str.equalsIgnoreCase("")) {
			return 0;
		}
		
		char[] strChar = str.toCharArray();
		int validThroughIndex = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(i==0 && !isValid(strChar[i])) {
				return 0;
			}
			
			if(i>0&&!isNum(strChar[i])) {
				validThroughIndex = i;
				break;
			}
			
			if((i==str.length()-1)) {
				validThroughIndex = i+1;
			}
		}
		
		if(validThroughIndex == 1 && isOprand(strChar[0])) {//only '+' or '-'
			return 0;
		}
		
		String validSnippet = str.substring(0, validThroughIndex);
		//handle big numbers
		if(isNum(strChar[0])) {//handle positive
			if(compareAbs(validSnippet, MAX) > 0) {
				return Integer.MAX_VALUE;
			}
		}else if(strChar[0]=='+'){//handle positive
			String tmp = validSnippet.substring(1);
			if(compareAbs(tmp, MAX) > 0) {
				return Integer.MAX_VALUE;
			}
		}else if(strChar[0]=='-'){//handle negative
			String tmp = validSnippet.substring(1);
			if(compareAbs(tmp, MIN) > 0) {
				return Integer.MIN_VALUE;
			}
		} else {
			throw new RuntimeException();
		}
		
		return Integer.valueOf(validSnippet);
	}
	
	private boolean isNum(char _c) {
		for(char i='0'; i<='9'; i++) {
			if(i==_c) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValid(char _c) {
		return isNum(_c) || isOprand(_c); 
	}
	
	private boolean isOprand(char _c) {
		return _c=='+' || _c=='-';
	}
	
	private int compareAbs(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return 1;
		} else if(s1.length() < s2.length()) {
			return -1;
		} else if(s1.equalsIgnoreCase(s2)){
			return 0;
		} else {
			char[] s1char = s1.toCharArray();
			char[] s2char = s2.toCharArray();
			
			for(int i=0; i<s1.length(); i++) {
				if(s1char[i]>s2char[i]) {
					return 1;
				} else if(s1char[i]<s2char[i]) {
					return -1;
				}
			}
			return 0;
		}
	}
}
