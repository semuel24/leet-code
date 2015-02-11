package valid.sudoku;

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author yaoxu
 *
 */
public class Solution {
	public static void main(String [] args) {
		char[][] board = 
			{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
			};
		
		Solution s = new Solution();
		System.out.println(s.isValidSudoku(board));
    }
	
	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> set = null;
		//validate rows
		for(int i=0; i<9; i++) {
			set = new HashSet<Character>();
			for(int j=0; j<9; j++) {
				if(set.contains(board[i][j])) {
					return false;
				}
				if(board[i][j] != '.'){
					set.add(board[i][j]);
				}
			}
		}
		//validate columns
		for(int j=0; j<9; j++) {
			set = new HashSet<Character>();
			for(int i=0; i<9; i++) {
				if(set.contains(board[i][j])) {
					return false;
				}
				if(board[i][j] != '.'){
					set.add(board[i][j]);
				}
			}
		}
		
		//validate blocks
		for(int i=0; i<9; i+=3) {
			for(int j=0; j<9; j+=3) {
				set = new HashSet<Character>();
				for(int k=i; k<i+3; k++) {
					for(int t=j; t<j+3; t++) {
						if(set.contains(board[k][t])) {
							return false;
						}
						if(board[k][t] != '.'){
							set.add(board[k][t]);
						}
					}
				}
			}
		}
		return true;
	}
}
