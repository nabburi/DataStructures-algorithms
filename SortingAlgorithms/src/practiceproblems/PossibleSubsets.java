package practiceproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PossibleSubsets {
	private final static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		PossibleSubsets ps = new PossibleSubsets();
		int[] nums = { 4,4,4,1,4 };
		List<Integer> slate = new ArrayList<Integer>();
		//sort-use quicksort
		quickSort(nums, 0, nums.length-1);
		helper(nums, 0, slate);
	}

	private static void quickSort(int[] nums, int start, int end) {
		if(start < end) {
			int randomIndex = start + (int)(Math.random() * ((end-start)+ 1));
			swap(nums, start, randomIndex);
			
			int pivot = nums[start];
			int i = end;
			for (int j = end; j > start; j--) {
				if(pivot <= nums[j]){
					swap(nums, i, j);
					i--;
				}
			}
			swap(nums, start, i);
			quickSort(nums, start, i);
			quickSort(nums, i+1, end);
		}
	}

	private static void helper(int[] nums, int i, List<Integer> slate) {
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
	
	public static void swap(int[] args, int i, int j) {
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}
	

}
