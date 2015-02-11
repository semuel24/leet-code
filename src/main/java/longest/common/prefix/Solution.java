package longest.common.prefix;

public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		String[] strs = {"ba","b"};
		System.out.println(s.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {

		if(strs == null || strs.length == 0) {
			return "";
		}
		
		if(strs.length == 1) {
			return strs[0];
		}
		
		int maxLength = Integer.MAX_VALUE;
		for(String _str : strs) {
			if(_str.length() < maxLength) {
				maxLength = _str.length();
			}
		}
		
		int cmPrefixPosition = -1;
		outerloop:
		for(int i=0; i<maxLength; i++) {
			char _char = 'a';
			boolean bFirstLoop = true;
			for(String _str : strs) {
				if(bFirstLoop) {
					_char = _str.charAt(i);
				} else {
					if(_str.charAt(i) != _char) {
						break outerloop;
					}
				}
				bFirstLoop = false;
			}
			cmPrefixPosition = i;
		}
		cmPrefixPosition++;
		if(cmPrefixPosition>maxLength) {
			return strs[0];
		} else {
			return strs[0].substring(0, cmPrefixPosition);
		}
	}
}
