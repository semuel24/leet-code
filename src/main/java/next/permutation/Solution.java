package next.permutation;

public class Solution {
    public void nextPermutation(int[] num) {
       if(num == null || num.length == 0) {
    	   return;
       }
        
       for(int i=num.length-2; i>=0; i--) {
    	   if(num[i] < num[i+1]) {
    		   for(int j=num.length-1; j>i; j--) {//find from right-most side
    			   if(num[j] > num[i]) {
    				   //swap
    				   int tmp = 0;
    				   tmp = num[i];
    				   num[i] = num[j];
    				   num[j] = tmp;
    				   reverse(num, i+1, num.length-1);
    				   return;
    			   }
    		   }
    	   }
       }
       
       reverse(num, 0, num.length-1);
       return;
    }
    
    private void reverse(int[] num, int startindex, int endindex) {
    	 if(num == null || num.length == 0) {
      	   return;
         }
    	 if(startindex > endindex) {
    		 return;
    	 }
    	 
    	 while(startindex <= endindex) {
			// swap
			int tmp = 0;
			tmp = num[startindex];
			num[startindex] = num[endindex];
			num[endindex] = tmp;
			
			startindex++;
			endindex--;
    	 }
    	 return;
    }
}
