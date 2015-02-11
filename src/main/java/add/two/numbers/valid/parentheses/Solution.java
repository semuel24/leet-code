package valid.parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author yaoxu
 * 
 */
public class Solution {
	
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("()[]{}"));
		System.out.println(s.isValid("([)]"));
		System.out.println(s.isValid("(]"));
	}
	
	public boolean isValid(String s) {
		if(s == null || s.equalsIgnoreCase("")) {
			return false;
		}
		
		Stack<Character> stk = new Stack<Character>();
		char [] chars = s.toCharArray();
		for(int i=0; i<chars.length; i++) {
			if(isLeft(chars[i])) {
				stk.push(chars[i]);
			}
			
			if(isRight(chars[i])) {
				if(stk.isEmpty()) {
					return false;
				} else {
					if(!isPair(stk.pop(), chars[i])) {
						return false;
					}
				}
			}
		}
		if(stk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isPair(char _left, char _right) {
		if(_left == '(' && _right == ')') {
			return true;
		}
		if(_left == '[' && _right == ']') {
			return true;
		}
		if(_left == '{' && _right == '}') {
			return true;
		}
		return false;
	}
	
	private boolean isLeft(char _c) {
		if(_c=='(' || _c=='[' || _c=='{') {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isRight(char _c) {
		if(_c==')' || _c==']' || _c=='}') {
			return true;
		} else {
			return false;
		}
	}
}
