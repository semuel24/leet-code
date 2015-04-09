package number.sum;

public class TwoSumSorted {

	public static void main(String[] args) {
		int[] numbers = {1,3,5,6,8};
		int target = 8;
		int [] result = twoSum(numbers, target);
		System.out.println(numbers[result[0]] + " | " + numbers[result[1]]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int forntIndex = 0;
		int backindex = numbers.length - 1;
		
		while(forntIndex < backindex) {
			int sum = numbers[forntIndex] + numbers[backindex];
			if(sum < target) {
				forntIndex++;
				continue;
			} else if(sum > target) {
				backindex--;
				continue;
			} else {//sum == target
				return new int[]{forntIndex, backindex};
			}
		}
		throw new RuntimeException("Can't find the result!");
	}
}
