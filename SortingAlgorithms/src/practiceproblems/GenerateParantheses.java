package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

	public static void main(String[] args) {
		List<String> result = new ArrayList<String>();
		int n = 3;
		char[] slate = new char[2 * n];
		helper(n,0, n, n, slate, result);
		System.out.println(result);
	}

	private static void helper(int n, int i, int left, int right, char[] slate, List<String> result) {

		if (left == 0 && right == 0) {
			result.add(String.valueOf(slate));
			return;
		}
		if (left > right || i == 2*n) {
			return;
		}
		// add (
		if (left > 0) {
			slate[i] = '(';
			helper(n, i+1, left - 1, right, slate, result);
			slate[i] = ' ';
		}
		// add )
		if (right > 0) {
			slate[i] = ')';
			helper(n, i +1, left, right - 1, slate, result);
			slate[i] = ' ';
		}
	}

}
