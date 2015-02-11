package reverse.words.in.a.string;

public class Solution {
    
    public static void main(String [] args) {
    	String orig = "   a   b  c d   e  ";
    	Solution s = new Solution();
    	System.out.println("###" + s.reverseWords(orig) + "###");
    }
    
    public String reverseWords(String s) {
    	if(s == null || s.equalsIgnoreCase("")) {
    		return "";
    	}
    	
    	s = s.trim();
    	String r = "";
    	String [] words = s.split("\\s+");
    	
    	for(int i=words.length-1; i>=0; i--) {
    		
    		r += words[i];
    		if(i!=0) {
    			r += " ";
    		}
    	}
    	return r;
    }
    
    
}
