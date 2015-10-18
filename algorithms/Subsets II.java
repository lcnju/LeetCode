// Given a collection of integers that might contain duplicates, nums, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If nums = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
                //答案有顺序要求
        Arrays.sort(nums);
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        answer.add(new ArrayList<Integer>());

        for (int num : nums) {
            ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
            temp.addAll(answer);
            Iterator<List<Integer>> iterator = temp.iterator();
            while (iterator.hasNext()) {
                ArrayList<Integer> numList = (ArrayList<Integer>) ((ArrayList<Integer>) iterator
                        .next()).clone();
                numList.add(num);
                answer.add((List<Integer>) numList);
            }
        }
        
        HashSet<List<Integer>> h = new HashSet<List<Integer>>(answer);  
        answer.clear();
        answer.addAll(h);

        return answer;
    }
}