package practiceproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PossibleSubsets {
	private final List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		PossibleSubsets ps = new PossibleSubsets();
		int[] nums = { 4,4,4,1,4 };
		List<Integer> slate = new ArrayList<Integer>();
		ps.helper(nums, 0, slate);
	}

	public void helper(int[] nums, int i, List<Integer> slate) {
		int count = 0;
		if (i >= nums.length) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}

		for (int j = 0; j < nums.length; j++) {
			if ((i < nums.length) && (nums[i] == nums[j])) {
				count += 1;
			}
		}

		// exclude
		helper(nums, i + count, slate);
		// include
		for (int j = 0; j < count; j++) {
			slate.add(nums[i]);
			helper(nums, i + count, slate);
		}
		for (int j = 0; j < count; j++) {
			slate.remove(slate.indexOf(nums[i]));
		}
	}

}
