package number.sum;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

	public static void main(String[] args) {
		
		FourSum f = new FourSum();
		int [] a = {-1,-5,-5,-3,2,5,0,4};
		int target = -7;
		ArrayList<ArrayList<Integer>> l = f.fourSum(a, target);
		f.printList(l);
	}
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> _l = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length-3;) {
        	for(int j=i+1; j<num.length-2;) {
        		int start = j+1;
        		int end = num.length-1;
        		
        		while(start < end) {
        			if(start > num.length-1 || end < j) {
        				break;
        			}
        			
        			if(num[i] + num[j] + num[start] + num[end] == target) {
        				int [] _a = {num[i], num[j], num[start], num[end]};
        				_l.add(createList(_a));
        				start++;
        				end--;
        				
        				while(start<num.length-1&&num[start]==num[start-1]) {
        					start++;
        				}
        				while(end>0 && num[end]==num[end+1]) {
        					end--;
        				}
        			} else if(num[i] + num[j] + num[start] + num[end] > target) {
        				end--;
        				while(end>0 && num[end]==num[end+1]) {
        					end--;
        				}
        			} else {//num[i] + num[j] + num[start] + num[end] < target
        				start++;
        				while(start<num.length-1&&num[start]==num[start-1]) {
        					start++;
        				}
        			}
        		}
        		
        		j++;
        		while(j<num.length&&num[j]==num[j-1]) {
        			j++;
        		}
        	}
        	
        	i++;
        	while(i<num.length&&num[i]==num[i-1]) {
    			i++;
    		}
        }
        
        return _l;
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
