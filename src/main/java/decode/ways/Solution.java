package decode.ways;

//http://blog.unieagle.net/2012/09/16/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Adecode-ways%EF%BC%8C%E4%B8%80%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().numDecodings("1"));
		System.out.println(new Solution().numDecodings("12"));
		System.out.println(new Solution().numDecodings("77"));
		System.out.println(new Solution().numDecodings("71"));
		System.out.println(new Solution().numDecodings("17"));
	}

	public int numDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] ways = new int[s.length()+1];
		ways[s.length()] = 1;//handle corner case
		for (int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == '0') {
				ways[i] = 0;
			} else {
				ways[i] = ways[i+1];
			}
			
			if(i< s.length()-1 && isValidCode(s.charAt(i), s.charAt(i+1))) {
				ways[i] += ways[i+2];
			}
		}
		return ways[0];
	}

	private boolean isValidCode(Character i, Character j) {
		if (i == null || j == null || i == '0') {
			return false;
		}
		return (i == '1' && j <= '9')
				|| (i == '2' && j <= '6');
	}
}
