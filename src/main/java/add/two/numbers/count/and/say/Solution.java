package count.and.say;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * @author yaoxu
 *
 */
public class Solution {

	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.countAndSay(1));
		System.out.println(s.countAndSay(2));
		System.out.println(s.countAndSay(3));
		System.out.println(s.countAndSay(4));
		System.out.println(s.countAndSay(5));
	}
	
	public String countAndSay(int n) {
		if(n == 0) {
			return null;
		}
		
		String sequence = "1";
		while(n-- > 1) {
			char[] chars = sequence.toCharArray();
			if(chars.length == 1) {
				sequence = "1" + String.valueOf(chars[0]);
				continue;
			}
			
			char lastChar = chars[0];
			int count = 1;
			sequence = "";
			for(int i=1; i<chars.length; i++) {
				if(chars[i] == lastChar) {
					count++;
				} else {
					sequence = sequence + count +String.valueOf(lastChar);
					lastChar = chars[i];
					count = 1;
				}
				
				if(i==chars.length-1) {//handle last char
					sequence = sequence + count +String.valueOf(lastChar);
				}
			}
		}
		return sequence;
	}
}
