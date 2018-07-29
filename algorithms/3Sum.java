// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int low = i + 1;
                int height = nums.length - 1;
                int sum = -nums[i];
                while (low < height) {
                    if (nums[low] + nums[height] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[low], nums[height]));
                        while (low < height && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < height && nums[height] == nums[height - 1]) {
                            height--;
                        }
                        low++;
                        height--;
                    } else if (nums[low] + nums[height] < sum) {
                        low++;
                    } else {
                        height--;
                    }
                }
            }
        }
        return ans;
    }
}