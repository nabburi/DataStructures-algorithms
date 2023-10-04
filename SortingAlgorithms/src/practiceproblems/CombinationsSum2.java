package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSum2 {

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> slate = new ArrayList<Integer>();
		int[] s = { 10, 1, 2, 7, 6, 1, 5 };
		quickSort(s, 0, s.length - 1);
		helper(s, 0, 8, slate, result);
		System.out.println(result);
	}

	private static void quickSort(int[] nums, int start, int end) {
		if (start < end) {
			int randomIndex = start + (int) (Math.random() * ((end - start) + 1));
			swap(nums, start, randomIndex);

			int pivot = nums[start];
			int i = end;
			for (int j = end; j > start; j--) {
				if (pivot <= nums[j]) {
					swap(nums, i, j);
					i--;
				}
			}
			swap(nums, start, i);
			quickSort(nums, start, i);
			quickSort(nums, i + 1, end);
		}
	}

	public static void swap(int[] args, int i, int j) {
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}

	private static void helper(int[] s, int i, int target, List<Integer> slate, List<List<Integer>> result) {

		int sum = slate.stream().mapToInt(Integer::intValue).sum();
		int count = 0;
		if (sum == target) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		if (i >= s.length || sum > target) {
			return;
		}
		for (int j = 0; j < s.length; j++) {
			if ((i < s.length) && (s[i] == s[j])) {
				count += 1;
			}
		}
		// exclude
		helper(s, i + count, target, slate, result);
		// include
		for (int j = 0; j < count; j++) {
			slate.add(s[i]);
			helper(s, i + count, target, slate, result);
		}
		for (int j = 0; j < count; j++) {
			slate.remove(slate.indexOf(s[i]));
		}
	}
}
