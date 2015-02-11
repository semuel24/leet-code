package com.fuhu.sanjose.rpn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String [] args) {
		String [] tokens = {"5","8","4","/","+"};
		int rpn = runRpn(tokens);
		System.out.println("rpn value is:" + rpn);
		
		
//		operations = new ArrayList<String>(Arrays.asList("4","1","+","2","*"));
//		rpn = runRpn(operations);
//		System.out.println("rpn value is:" + rpn);
	}
	
	private static int runRpn(String [] _arr) {
		List<String> _in = new ArrayList<String>(Arrays.asList(_arr));
		if(_in == null) {
			throw new RuntimeException("Empty input list !");
		}
		
		Stack<String> stack = new Stack<String>();
		
		for(String _element : _in) {
			if( !isOperand(_element) ) {//find a digit, push it to stack
				stack.push(_element);
			} else {//find an operand, get previous 2 and 
				int int2 = Integer.parseInt(stack.pop());
				int int1 = Integer.parseInt(stack.pop());
				stack.push(Integer.toString(runRpn(int1, int2, _element)));
			}
		}
		
		return Integer.parseInt(stack.peek());
	}
	
	private static int runRpn(int d1, int d2, String op) {
		if("+".equalsIgnoreCase(op)) {
			return d1 + d2;
		} else if("-".equalsIgnoreCase(op)) {
			return d1 - d2;
		} else if("*".equalsIgnoreCase(op)) {
			return d1 * d2;
		}else if("/".equalsIgnoreCase(op)) {
			return d1 / d2;
		} else {
			throw new RuntimeException("Invalid operand !");
		}
	}
	
	private static boolean isOperand(String op) {
		if("+".equalsIgnoreCase(op)) {
			return true;
		} else if("-".equalsIgnoreCase(op)) {
			return true;
		} else if("*".equalsIgnoreCase(op)) {
			return true;
		}else if("/".equalsIgnoreCase(op)) {
			return true;
		} else {
			return false;
		}
	}
}
