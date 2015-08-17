// Given a collection of numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
    	return permutations(nums, nums.length);
    }
    
    private List<List<Integer>> permutations(int[] nums, int length) {
    	List<List<Integer>> answer = new ArrayList<List<Integer>>();
    	if (length == 1) {
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.add(nums[0]);
    		answer.add(temp);
    	} else if (length > 1) {
    		List<List<Integer>> next = permutations(nums, length-1);
    		for(List<Integer> n:next) {
    			for (int i = 0; i < n.size(); i++) {
    				List<Integer> each = new ArrayList<Integer>();
    				each.addAll(n);
    				each.add(i, nums[length-1]);
    				answer.add(each);
    			}
				List<Integer> end = new ArrayList<Integer>();
				end.addAll(n);
				end.add(nums[length-1]);
				answer.add(end);
    		}
    	}
    	return answer;
    }
}