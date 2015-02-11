package number.sum;

import java.util.Arrays;

public class ThreeSumClose {

	public static void main(String [] args) {
		ThreeSumClose t = new ThreeSumClose();
		int [] a = {4,0,5,-5,3,3,0,-4,-5};
		int target = -2;
		int r = t.threeSumClosest(a, target);
		System.out.println(r);
	}
	
	public int threeSumClosest(int[] num, int target) {
		int closestSum = Integer.MAX_VALUE/2;
		Arrays.sort(num);
		
		for(int i=0; i<num.length-2; i++) {			
			SUM_STATUS _status = SUM_STATUS.ORIGINAL;
			int start = i+1;
			int end = num.length-1;
			
			while(start < end) {
				System.out.println("closestSum:" + closestSum + "=num[" + i + "]:" + num[i] + "+ num[" + start + "]:" + num[start] + "+ num[" + end + "]" + num[end]);
				int mindiff = closestSum>target ? (closestSum-target):(target-closestSum);
				
				if(num[i] + num[start] + num[end] == target) {
					closestSum = target;
					System.out.println("closestSum:" + closestSum + "=num[" + i + "]:" + num[i] + "+ num[" + start + "]:" + num[start] + "+ num[" + end + "]" + num[end]);
					return closestSum;
				} else if(num[i] + num[start] + num[end] > target) {
					if(num[i] + num[start] + num[end] - target < mindiff) {
						closestSum = num[i] + num[start] + num[end];
						System.out.println("closestSum:" + closestSum + "=num[" + i + "]:" + num[i] + "+ num[" + start + "]:" + num[start] + "+ num[" + end + "]" + num[end]);
					}
					
					end --;
					
//					if(_status.equals(SUM_STATUS.LESS)) {//if the sum passes the target
//						break;//jump out of while
//					}
					_status = SUM_STATUS.BIGGER;
				}else {//num[i] + num[start] + num[end] < target
					if (target - num[i] - num[start] - num[end] < mindiff) {
						closestSum = num[i] + num[start] + num[end];
						System.out.println("closestSum:" + closestSum + "=num[" + i + "]:" + num[i] + "+ num[" + start + "]:" + num[start] + "+ num[" + end + "]" + num[end]);
					}

					start++;
//					
//					if(_status.equals(SUM_STATUS.BIGGER)) {//if the sum passes the target
//						break;//jump out of while
//					}
					_status = SUM_STATUS.LESS;
				}
			}	
		}
		
		return closestSum;
    }
	
	private enum SUM_STATUS {
		LESS,
		BIGGER,
		ORIGINAL;
	}
	
	
}
