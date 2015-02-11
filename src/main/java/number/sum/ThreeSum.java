package number.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class ThreeSum {

	public static void main(String [] args) {
		ThreeSum t = new ThreeSum();
//		int [] num = {-3, 1, 2, 0, -1, -2, 3, 3, -3, 0};
		int [] num = {0,0,0};
		ArrayList<ArrayList<Integer>> l = t.threeSum(num);
		t.printList(l);
	}
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(num == null || num.length < 3) {
			return result;
		}
		
		Arrays.sort(num);
		
		for(int i=0; i< num.length-2; i++) {
			
//			if(num[i] == num[i+1]) {
//				continue;
//			}
			
			int start = i+1;
			int end = num.length - 1;
			while(start < end) {
				if(num[i] + num[start] + num[end] == 0) {
					int [] _a = {num[i], num[start], num[end]};
					result.add(createList(_a));
					
					start ++;
					end --;
					while(start < num.length && num[start] == num[start-1]) {
						start++;
					}
					while(end > 0 && num[end] == num[end+1]) {
						end--;
					}
				}else if(num[i] + num[start] + num[end] > 0) {
					end --;
				}else {//num[i] + num[start] + num[end] < 0
					start ++;
				}
			}
			
			while(i < num.length-1 && num[i] == num[i+1] ) {
				i++;
			}
		}
		
		return result;
	}
	
	private ArrayList<Integer> createList(int [] _num) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		if(_num == null || _num.length == 0) {
			return a;
		}
		
		for(int i=0; i< _num.length; i++) {
			a.add(_num[i]);
		}
		return a;
	}
	
	private void printList(ArrayList<ArrayList<Integer>> _aa) {
		for(ArrayList<Integer> _a : _aa) {
			System.out.println("");
			for(Integer _i : _a) {
				System.out.print(_i + "  ");
			}
		}
	}
	
	
	
	
}
