package practiceproblems;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		String s = "1-(     -2)";
		calculate(s);
	}

	public static int calculate(String s) {
		int sign = 1;
		Stack<Integer> preSigns = new Stack<>();
		Stack<Integer> preSums = new Stack<>();

		int num = 0;
		int sum = 0;

		for (char c : s.toCharArray()) {
			if (c == ' ') {
				continue;
			} else if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else if (c == '+') {
				sum += sign * num;
				sign = 1;
				num = 0;
			} else if (c == '-') {
				sum += sign * num;
				sign = -1;
				num = 0;
			} else if (c == '(') {
				preSigns.push(sign);
				preSums.push(sum);
				sign = 1;
				sum = 0;
			} else { // c == ')'
				sum += sign * num;
				sum = preSigns.pop() * sum + preSums.pop();
				sign = 1;
				num = 0;
			}
		}

		return sum + sign * num;

	}

}
