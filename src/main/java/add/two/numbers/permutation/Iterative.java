package permutation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Iterative {

	public static void main(String [] args) {
		Map map = new HashMap();
		
		String key = "key";
		map.put(key, 1);
		map.put(key, 2);
		
		System.out.println(map.get(key));
	}
	
//	private int factorial(int n) {
//		return (n == 1 || n == 0) ? 1 : factorial(n - 1) * n; 
//	}
//	
//	private void plusp(Integer[] p, Integer[] bound) {
//		int i = p.length-1;  
//        while(i >= 0){  
//            if(p[i] < bound[i]){  
//                p[i]++;  
//                break;  
//            }else{  
//                p[i] = 0;  
//                i--;  
//            }  
//        }  
//	}
//	
//	public List<List<Integer>> permute (Integer[] num) {
//		
//	}
}
