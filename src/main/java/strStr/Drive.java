package strStr;

public class Drive {

	public static void main(String[] args) {
		String haystack = "";
		String needle = "";
		int start = strStr(haystack, needle);
		if(start != -1) {
			System.out.println(haystack.substring(start, start + needle.length()));
		} else {
			System.out.println("Didn't find the target !");
		}
		
	}
	
	public static int strStr(String source, String target) {
		if(source == null || target == null) {
			return -1;
		}
		
		if(source.length() < target.length()) {
			return -1;
		}
		
		if(target.equalsIgnoreCase("")) {
			return 0;
		}
		
		for(int i = 0; i < source.length() - target.length() + 1; i++) {
			for(int j = 0; j < target.length(); j++) {
				if(source.charAt(i+j) == target.charAt(j) && j == target.length() - 1) {
					return i;
				}
				
				if(source.charAt(i+j) == target.charAt(j)) {
					continue;
				} else {
					break;
				}
			}
		}
        return -1;
    }
}
