package misc;

import java.util.ArrayList;

public class Subsets {

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
		if (set == null || set.size() == 0)
			return null;

		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets.add(new ArrayList<Integer>());

		for (int i : set) {
			ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> s : subsets) {

				newSubsets.add(s);
				ArrayList<Integer> l = new ArrayList<Integer>();
				// copy all elements from s to l. add i.
				for (int x : s) {
					l.add(x);
				}
				l.add(i);
				newSubsets.add(l);

			}
			subsets = newSubsets;

		}
		return subsets;
	}

	private static void printSubsets(ArrayList<ArrayList<Integer>> subsets) {
		for (ArrayList<Integer> s : subsets) {
			System.out.print("{");
			for (int x : s) {
				System.out.print(x + ",");
			}
			System.out.println("}");
		}

	}
	
	public static void main(String[] args) {
		ArrayList<Integer> s = new ArrayList<Integer>() 
				{{ add(1); add(2);}};
				
				printSubsets(subsets(s));
		
	}
}
