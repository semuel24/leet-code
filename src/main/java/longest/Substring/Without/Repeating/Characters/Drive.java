package longest.Substring.Without.Repeating.Characters;

import java.util.HashSet;
import java.util.Set;

public class Drive {

	public static void main(String[] args) {
		System.out
				.println(new Drive().lengthOfLongestSubstring("abcdefghaxyz"));
		// System.out.println(new Drive()
		// .lengthOfLongestSubstring("abcdefghaexyz"));
		// System.out.println(new Drive()
		// .lengthOfLongestSubstring("abcdeefghjaexyz"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}

		Set<Character> chars = new HashSet<Character>();
		int maxi = 0, maxl = 1;
		int sumi = 0, suml = 1;
		int i = 0, j = 1;// 2 pointers, j is leading, j is following
		chars.add(s.charAt(0));

		while (j < s.length()) {//finish when leading j reaches end
			if (!chars.contains(s.charAt(j))) {// change leading j
				chars.add(s.charAt(j));
				j++;
				suml = j - i;
				maxl = maxl > suml ? maxl : suml;
			} else {// change following i
				
				//abbbbbbba
				//xabdfsdfia
				//aa
				while (i < j && (s.charAt(i) != s.charAt(j))) {
					i++;
				}
				i++;
				sumi = i;
				suml = j - i;
				maxi = maxl > suml ? maxi : sumi;
				suml = maxl > suml ? maxl : suml;
				j++;
			}
		}

		for (int _i = 0; _i < maxl; _i++) {
			System.out.print(s.charAt(maxi + _i) + "|");
		}
		return maxl;
	}
}
