package src.dp.AllWaysToAddParenthesisForEvaluation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TopDownDp {

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

	public static Set<Integer> calc(String input) {

		int len = input.length();
		boolean opFound= false;
		Set<Integer> ans = new HashSet<Integer>();

		for(int i=0;i<len;++i){
			if(isOperator(input.charAt(i))){

				Set<Integer> s1,s2;
				if(dp.get(input.substring(0, i)) != null )
					s1 = dp.get(input.substring(0, i));
				else
					s1 = calc(input.substring(0, i));

				if(dp.get(input.substring(i+1)) != null )
					s2 = dp.get(input.substring(i+1));
				else
					s2 = calc(input.substring(i+1));

				opFound = true;

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

		if(!opFound)
			ans.add(Integer.parseInt(input));

		dp.put(input, ans);
		return ans;
	}

	public static void main(String[] args) {
		String input = "5*4-3*2+5";
		Set<Integer> ans = calc(input);
		System.out.println(ans);

	}

}
