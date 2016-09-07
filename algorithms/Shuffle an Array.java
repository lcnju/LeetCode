// Shuffle a set of numbers without duplicates.

// Example:

// // Init an array with set 1, 2, and 3.
// int[] nums = {1,2,3};
// Solution solution = new Solution(nums);

// // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
// solution.shuffle();

// // Resets the array back to its original configuration [1,2,3].
// solution.reset();

// // Returns the random shuffling of array [1,2,3].
// solution.shuffle();

public class Solution {

    private int[] nums;
    private int[] shuffle;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        shuffle = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffle = Arrays.copyOf(nums, nums.length);
        return shuffle;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < shuffle.length; i++) {
            int j = random.nextInt(shuffle.length);
            int temp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = temp;
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */