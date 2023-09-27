package practiceproblems;

import java.util.ArrayList;
import java.util.*;

import org.apache.commons.lang3.ArrayUtils;

public class LetterCasePermutation {
	
	ArrayList<String> result = new ArrayList<String>();

	public static void main(String[] args) {
		String s = "a1b2";
		LetterCasePermutation lcp = new LetterCasePermutation();
		char[] slate = new char[s.length()]; 
		lcp.helper(s, 0, slate);

	}
	
	public void helper(String s, int i, char[] slate) {
		
		if(i == s.length()) {
			result.add(String.valueOf(slate));
			return;
		}
		
		if(Character.isDigit(s.charAt(i))) {
			slate[i] = s.charAt(i);
			helper(s,i+1, slate);
			slate[i] = ' ';
		}else {
			slate[i] = Character.toLowerCase(s.charAt(i));
			helper(s,i+1, slate);
			slate[i] = ' ';
			
			slate[i] = Character.toUpperCase(s.charAt(i));
			helper(s,i+1, slate);
			slate[i] = ' ';
		}
	}
}
