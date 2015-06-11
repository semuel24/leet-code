package isomorphic.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String [] args) {
		System.out.println(new Solution().isIsomorphic("egg", "add"));
		System.out.println(new Solution().isIsomorphic("foo", "bar"));
		System.out.println(new Solution().isIsomorphic("paper", "title"));
		System.out.println(new Solution().isIsomorphic("ab", "aa"));
	}
	
	public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) {
        	return false;
        }
        
        if(s.length() != t.length()) {
        	return false;
        }
        
        Map<Character, Character> dict = new HashMap<Character, Character>();
        Set<Character> targets = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
        	if(!dict.containsKey(s.charAt(i))) {
        		if(targets.contains(t.charAt(i))) {
        			return false;
        		}
        		targets.add(t.charAt(i));
        		dict.put(s.charAt(i), t.charAt(i));
        	}
        	
        	if(dict.get(s.charAt(i)) != t.charAt(i)) {
        		return false;
        	}
        }
        return true;
    }
}
