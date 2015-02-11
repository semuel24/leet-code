package length.of.last.word;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 * @author yaoxu
 *
 */
public class Solution {
    public int lengthOfLastWord(String s) {
    	if(s == null) {
    		return 0;
    	}
    	s = s.trim();
    	String [] words = s.split(" ");
    	int l_length = 0;
    	int a_length = words.length;
    	if(a_length == 0) {
    		l_length = 0;
    	} else if(a_length == 1) {
    		l_length = words[0].length();
    	} else {
    		l_length = words[a_length-1].length();
    	}
    	
    	return l_length;
    }
}