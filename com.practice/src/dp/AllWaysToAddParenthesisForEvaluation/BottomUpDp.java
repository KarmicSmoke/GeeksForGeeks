package src.dp.AllWaysToAddParenthesisForEvaluation;

import java.util.*;

public class BottomUpDp {

	public static HashMap<String, Set<Integer>> dp = new HashMap<String, Set<Integer>>();

	public static boolean isOperator(char op) {

		return (op == '*' || op == '-' || op == '+' || op == '/');
	}

	public static Set<Integer> multiplicationOfSets(Set<Integer> s1, Set<Integer> s2) {

		Set<Integer> ans = new HashSet<Integer>();

		Iterator<Integer> setOneIterator = s1.iterator();

		while (setOneIterator.hasNext()) {
			int v1 = (int) setOneIterator.next();
			Iterator<Integer> setTwoIterator = s2.iterator();
			while (setTwoIterator.hasNext()) {
				int v2 = (int) setTwoIterator.next();
				ans.add(v1 * v2);
			}
		}

		return ans;
	}

	public static Set<Integer> differenceOfSets(Set<Integer> s1, Set<Integer> s2) {

		Set<Integer> ans = new HashSet<Integer>();

		Iterator<Integer> setOneIterator = s1.iterator();

		while (setOneIterator.hasNext()) {
			int v1 = (int) setOneIterator.next();
			Iterator<Integer> setTwoIterator = s2.iterator();
			while (setTwoIterator.hasNext()) {
				int v2 = (int) setTwoIterator.next();
				ans.add(v1 - v2);
			}
		}

		return ans;
	}

	public static Set<Integer> additionOfSets(Set<Integer> s1, Set<Integer> s2) {
		Set<Integer> ans = new HashSet<Integer>();

		Iterator<Integer> setOneIterator = s1.iterator();

		while (setOneIterator.hasNext()) {
			int v1 = (int) setOneIterator.next();
			Iterator<Integer> setTwoIterator = s2.iterator();
			while (setTwoIterator.hasNext()) {
				int v2 = (int) setTwoIterator.next();
				ans.add(v1 + v2);
			}

		}

		return ans;
	}

	public static Set<Integer> divisionOfSets(Set<Integer> s1, Set<Integer> s2) {
		Set<Integer> ans = new HashSet<Integer>();

		Iterator<Integer> setOneIterator = s1.iterator();

		while (setOneIterator.hasNext()) {
			int v1 = (int) setOneIterator.next();
			Iterator<Integer> setTwoIterator = s2.iterator();
			while (setTwoIterator.hasNext()) {
				int v2 = (int) setTwoIterator.next();
				ans.add(v1 / v2);
			}
		}

		return ans;
	}

	public static Set<Integer> eval(String input) {

		Set<Integer> ans = new HashSet<Integer>();
		int len = input.length();

		for (int i = 0; i < input.length(); ++i) {
			if (isOperator(input.charAt(i))) {

				Set<Integer> s1 = dp.get(input.substring(0, i));
				Set<Integer> s2 = dp.get(input.substring(i + 1, len));

				if (input.charAt(i) == '*')
					ans.addAll(multiplicationOfSets(s1, s2));
				else if (input.charAt(i) == '-')
					ans.addAll(differenceOfSets(s1, s2));
				else if (input.charAt(i) == '+')
					ans.addAll(additionOfSets(s1, s2));
				else
					ans.addAll(divisionOfSets(s1, s2));

			}
		}

		return ans;

	}

	public static Set<Integer> calc(String input) {

		int len = input.length();

		ArrayList<Integer> index = new ArrayList<Integer>();
		index.add(-1);
		for (int i = 0; i < len; ++i)
			if (isOperator(input.charAt(i)))
				index.add(i);
		index.add(len);


		for (int begin = 0; begin + 1 < index.size(); ++begin) {
			int strBegin = index.get(begin);
			int strEnd = index.get(begin + 1);
			Set<Integer> s = new HashSet<Integer>();
			s.add(Integer.parseInt(input.substring(strBegin + 1, strEnd)));
			dp.put(input.substring(strBegin + 1, strEnd), s);
		}

		for (int noOfOperator = 1; noOfOperator <= index.size() - 2; ++noOfOperator) {
			for (int begin = 0; begin + noOfOperator + 1 < index.size(); ++begin) {
				int strBegin = index.get(begin);
				int strEnd = index.get(begin + noOfOperator + 1);
				dp.put(input.substring(strBegin + 1, strEnd), eval(input.substring(strBegin + 1, strEnd)));
			}
		}

		return dp.get(input.substring(0));

	}

	public static void main(String[] args) {

		String input = "5*4-3*2+5";
		Set<Integer> ans = calc(input);
		System.out.println(ans);

	}
}
