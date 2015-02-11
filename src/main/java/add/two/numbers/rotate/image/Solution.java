package rotate.image;

public class Solution {
	
	public static void main(String [] args) {
		int [][] matrix = {{1, 2, 3, 4 }, { 5, 6,7,8}, {9,10,11,12},{13,14,15,16}};
		Solution s = new Solution();
		s.printMatrix(matrix);
		s.rotate(matrix);
		s.printMatrix(matrix);
	}
	
	private void printMatrix(int[][] matrix) {
		
//		System.out.println(" ");
		
		int n = matrix.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int level=0; level<n/2; level++) {
			for(int pointer=level; pointer<n-level-1; pointer++) {
				//cache top point
				int temp1 = matrix[level][pointer]; 
				//cache right point
				int temp2 = matrix[pointer][n-level-1];
				//cache bottom point
				int temp3 = matrix[n-level-1][n-pointer-1];
				//cache left point
				int temp4 = matrix[n-pointer-1][level];
				
				//top -> right
				matrix[pointer][n-level-1] = temp1;
				//right -> bottom
				matrix[n-level-1][n-pointer-1] = temp2;
				//bottom -> left
				matrix[n-pointer-1][level] = temp3;
				//left -> top
				matrix[level][pointer] = temp4;
			}
		}
	}
}
