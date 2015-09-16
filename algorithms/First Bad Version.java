// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
	public int firstBadVersion(int n) {
		int begin = 1;
		int end = n;
		int mid = 0;
		while (begin < end - 1) {
			//二分时,　太大会越界
			mid = (int) (begin / 2.0 + end / 2.0);
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				begin = mid;
			}
		}
		if (isBadVersion(begin)) {
			return begin;
		} else {
			return end;
		}
	}
}