package permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class II {

	public static void main(String[] args) {
		II ii = new II();
		int[] num = {1,2, 3, 3 };
		ArrayList<ArrayList<Integer>> ll = ii.permute(num);
		ii.printList(ll);
	}

	private void printList(ArrayList<ArrayList<Integer>> _aa) {
		for(ArrayList<Integer> _a : _aa) {
			System.out.println("");
			for(Integer _i : _a) {
				System.out.print(_i + "  ");
			}
		}
	}	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int n = num.length;
		boolean[] visited = new boolean[n];

		permuteImp(res, tmp, num, visited);

		return res;
	}

	private void permuteImp(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> tmp, int[] num, boolean[] visited) {
		if (tmp.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				if(i>0 && num[i] == num[i-1] && visited[i-1]) {
					continue;
				}
				tmp.add(num[i]);
				visited[i] = true;
				permuteImp(res, tmp, num, visited);
				visited[i] = false;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
