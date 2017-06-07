#include "Vlpp.h"
#include <stdint.h>

class Solution {
public:
	int reverse(int x) {
		int64_t r = 0;
		do {
			r = r * 10 + x % 10;
		} while (x = x / 10);
		if (abs(r) > 0x7fffffff)
			r = 0;
		return (int)r;
	}
};

using namespace vl;

TEST_CASE(Test007) {
	Solution sol;
	TEST_ASSERT(sol.reverse(1234) == 4321);
	TEST_ASSERT(sol.reverse(-123) == -321);
	TEST_ASSERT(sol.reverse(1000000003) == 0);
}