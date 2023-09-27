package practiceproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PossiblePermutations {

	private final List<List<Integer>> result = new ArrayList<List<Integer>>();
	

	public static void main(String[] args) {
		PossiblePermutations pp = new PossiblePermutations();
		int[] nums = { 3,3,0,3 };
		List<Integer> slate = new ArrayList<Integer>();
		pp.helper(nums, 0, slate);
	}

	private void helper(int[] nums, int i, List<Integer> slate) {
		if (i == nums.length) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		HashMap countnum = new HashMap();
		for (int j = i; j < nums.length; j++) {
			if (countnum.containsValue(nums[j])){
				continue;
			}
			countnum.put(Math.random(), nums[j]);
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
			slate.add(nums[i]);
			helper(nums, i + 1, slate);
			slate.remove(slate.size()-1);
			temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
	}
	private void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}
