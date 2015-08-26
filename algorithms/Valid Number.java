// Validate if a given string is numeric.

// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

public class Solution {

	public boolean isNumber(String s) {
		try {
			s = s.trim().toLowerCase();
			for (int i = 0; i < s.length(); i++) {
				if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'd') || (s.charAt(i) >= 'f' && s.charAt(i) <= 'z')) {
					return false;
				}
					
			}
			Double num = Double.parseDouble(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}