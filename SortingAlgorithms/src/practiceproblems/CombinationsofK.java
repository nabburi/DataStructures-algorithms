package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class CombinationsofK {

	public static void main(String[] args) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	int[] s = new int[1];
	for (int j = 0; j < 1; j++) {
			s[j] = j+1;
		}
	List<Integer> slate = new ArrayList<Integer>();
	int k =2;
	helper(s, 0, result, slate, 1);
	System.out.println(result);
	}
	
	private static void helper(int[] s, int i, List<List<Integer>> result, List<Integer> slate, int k) {
		if(slate.size()== k) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		
		if(i == s.length) {
			return;
		}
		
		//exclude
		helper(s, i+1, result, slate, k);
		//include
		slate.add(s[i]);
		helper(s, i+1, result, slate, k);
		slate.remove(slate.indexOf(s[i]));
	}
}
