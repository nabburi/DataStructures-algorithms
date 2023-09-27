package practiceproblems;

import java.util.Stack;

public class ValidateParentheses {

	public static void main(String[] args) {
		String s = "([)]";
		Stack<Character> stack = new Stack<>();

		for (char x : s.toCharArray()) {

			if (x == '(') {

				stack.push(')');
			} else if (x == '{') {
				stack.push('}');

			} else if (x == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != x) {
				//return false;
			}
		}
		//return stack.isEmpty();
	}
}
