package dynamicpractice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {

		int candidates[] = { 10, 2, 12};
		int target = 12;
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		combinationSum2(0, candidates, target, res, new ArrayList<Integer>());

		System.out.println(res);

	}

	private static void combinationSum2(int ind, int[] candidates, int target, List<List<Integer>> res,
			List<Integer> ds) {

		// base condition

		if (ind == candidates.length) {
			if (target == 0) {
				res.add(ds);
				System.out.println(ds);
			}
			return;
		}
		if (target >= candidates[ind]) {
			ds.add(candidates[ind]);
			combinationSum2(ind + 1, candidates, target - candidates[ind], res, ds);

			ds.remove(ds.size() - 1);
		
		}
		combinationSum2(ind + 1, candidates, target, res, ds);

	}

}
