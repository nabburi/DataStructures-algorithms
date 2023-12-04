package practiceproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationsSum {
	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> slate = new ArrayList<Integer>();
		int[] s = { 1, 2, 3, 6, 7 };
		helper(s, 0, 7, slate, result);
		System.out.println(result);
		Stack<String> se = new Stack<String>();
	}

	private static void helper(int[] s, int i, int target, List<Integer> slate, List<List<Integer>> result) {

		int sum = slate.stream().mapToInt(Integer::intValue).sum();
		if (sum == target) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		if ( i >= s.length || sum > target) {
			return;
		}
		// exclude
		helper(s, i + 1, target, slate, result);
		// include
		slate.add(s[i]);
		helper(s, i, target, slate, result);
		slate.remove(slate.indexOf(s[i]));
	}
}
