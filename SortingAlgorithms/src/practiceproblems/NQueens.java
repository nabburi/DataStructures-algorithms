package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		int n = 4;
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> slate = new ArrayList<String>();
		char[] qs = new char[n];
		for (int i = 0; i < n; i++) {
			qs[i] = '.';
		}
		helper(n, 0, 0, qs,slate, result);
		System.out.println(result);
	}

	private static void helper(int n, int i, int j, char[] qs, List<String> slate, List<List<String>> result) {
		// backtracking

		if (!slate.isEmpty()) {
			int lastq = slate.size()-1;

			for (int k = 0; k < lastq; k++) {
				// check for column conflict
				if (slate.get(k).charAt(j) =='Q' && slate.get(lastq).charAt(j) == 'Q') {
					return;
				}
				// check for diagonal conflict
				int rowdiff = Math.abs(lastq - k);
				int coldiff = Math.abs(slate.get(lastq).indexOf('Q') - slate.get(k).indexOf('Q'));
				if (rowdiff == coldiff) {
					return;
				}
			}
		}
		// base-case
		if (i == n) {
			result.add(new ArrayList<String>(slate));
			return;
		}

		// Recursion
		for (j = 0; j <n; j++) {
			String fs = String.valueOf(qs);
			fs = fs.substring(0, j) + 'Q' + fs.substring(j + 1);
			slate.add(fs);
			helper(n, i+1, j, qs,slate, result);
			slate.remove(slate.size()-1);
		}
	}

}
