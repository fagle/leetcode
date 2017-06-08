#include "Vlpp.h"
#include <stdint.h>

class Solution {
public:
	bool isPalindrome(int x) {
		int a = x;
		if (a < 0)
			return false;
		if (a < 10)
			return true;
		int64_t r = 0;
		do {
			r = r * 10 + a % 10;
		} while (a = a / 10);
		if ((int)r == x)
			return true;
		return false;
	}
};

using namespace vl;

TEST_CASE(Test009) {
	Solution sol;
	TEST_ASSERT(sol.isPalindrome(-1) == false);
	TEST_ASSERT(sol.isPalindrome(1) == true);
	TEST_ASSERT(sol.isPalindrome(121) == true);
	TEST_ASSERT(sol.isPalindrome(22) == true);
}