// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = m + n - 1;
		int q1 = m - 1;
		int q2 = n - 1;
		for (int i = p; i >= 0; i--) {
			if (q1 < 0 && q2 >= 0) {
				nums1[i] = nums2[q2];
				q2--;
			} else if (q1 >= 0 && q2 < 0) {
				nums1[i] = nums1[q1];
				q1--;
			} else {
				if (nums1[q1] > nums2[q2]) {
					nums1[i] = nums1[q1];
					q1--;
				} else {
					nums1[i] = nums2[q2];
					q2--;
				}
			}
		}
	}
}