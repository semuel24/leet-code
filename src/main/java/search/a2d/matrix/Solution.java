package search.a2d.matrix;

public class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
		
		//validation
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0) {
			return false;
		}
		
		//find row
		int start = 0;
		int end = matrix.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start)/2;
			if(matrix[mid][0] == target) {
				return true;
			} else if(matrix[mid][0] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		int row = 0;
		if(matrix[end][0] <= target) {
			row = end;
		} else if(matrix[start][0] <= target) {
			row = start;
		} else {
			return false;
		}
		
		//search column
		start = 0;
		end = matrix[row].length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start)/2;
			if(matrix[row][mid] == target) {
				end = mid;
			} else if(matrix[row][mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if(matrix[row][start] == target) {
			return true;
		} else if (matrix[row][end] == target) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String [] args) {
		int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}}; 
		System.out.println(new Solution().searchMatrix(matrix, 4));
	}
	
}
