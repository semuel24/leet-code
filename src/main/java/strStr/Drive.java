package strStr;

public class Drive {

	public static void main(String[] args) {
		String haystack = "";
		String needle = "";
		int start = strStr(haystack, needle);
		System.out.println(haystack.substring(start, start + needle.length()));
	}

	public static int strStr(String haystack, String needle) {
		
		
		if (haystack == null || needle == null) {
			return -1;
		}
		
		if("".equalsIgnoreCase(needle)) {
			return 0;
		}

		int i = 0;
		while (i < haystack.length()) {
			int tmpi = i;
			int j = 0;
			while (j < needle.length()) {
				if (tmpi == haystack.length()) {
					return -1;
				} else if (haystack.charAt(tmpi) == needle.charAt(j)) {
					if (j == needle.length() - 1) {
						return i;
					} else {
						tmpi++;
						j++;
					}
				} else {
					break;
				}
			}
			i++;
		}
		return -1;
	}
}
