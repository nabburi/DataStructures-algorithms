package practiceproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	private final static List<String> result = new ArrayList<String>();

	public static void main(String[] args) {
		Map<Character, String> hm = new HashMap<>();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");
		String s = "";
		
		char[] slate = new char[s.length()]; 
		helper(s, 0, hm, "2", slate);
	}

	private static void helper(String ipstr, int i, Map hm, String ltrstr, char[] slate) {
		if (i == ipstr.length()) {
			result.add(String.valueOf(slate));
			return;
		}
		char mapkey = ipstr.charAt(i);
		ltrstr = (String) hm.get(mapkey);
		for (int j = 0; j < ltrstr.length(); j++) {
			slate[i] = ltrstr.charAt(j);
			helper(ipstr, i+1, hm, ltrstr, slate);
			slate[i] = ' ';
		}
	}

}
