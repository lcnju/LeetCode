// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3]

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return calc(candidates, target, 0);
    }
    
    private List<List<Integer>> calc(int[] candidates, int target, int index) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> single = new ArrayList<Integer>();
                single.add(target);
                answer.add(single);
            } else if (candidates[i] < target) {
                List<List<Integer>> next = calc(candidates, target
                        - candidates[i], i);
                Iterator<List<Integer>> iterator = next.iterator();
                while (iterator.hasNext()) {
                    List<Integer> each = iterator.next();
                    each.add(0, candidates[i]);
                    answer.add(each);
                }
            }
        }
        return answer;
    }
} 