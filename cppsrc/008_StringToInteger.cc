#include "Vlpp.h"
#include <string>
#include <iostream>

using std::string;

class Solution {
public:
	int myAtoi(string str) {
		if (str.empty())
			return 0;
		char  c = str[str.length()-1];
		while (c == ' ') {
			str.erase(str.length()-1, 1);
			if (!str.empty())
				c = str[str.length() - 1];
			else
				c = 0;
		}
		c = str[0];
		while (c == ' ') {
			str.erase(0, 1);
			if (!str.empty())
				c = str[0];
			else
				c = 0;
		}

		if (str.empty())
			return 0;
		bool neg = false;
		int begin = 0;
		if (!isdigit(c) && c != '-' && c != '+')
			return 0;
		else if (c == '-') {
			neg = true;
			begin = 1;
		}
		else if (c == '+')
			begin = 1;
		int64_t r = 0;
		for (size_t i = begin; i < str.length(); i++) {
			char c = str[i];
			if (!isdigit(c))
				break;
			char a = c - '0';
			r = r * 10 + a;
			if (r > 0x7fffffff && !neg) {
				r = 0x7fffffff;
				break;
			}
			if (neg && r > 0x80000000) {
				r = 0x80000000;
				break;
			}
		}
		
		if (neg)
			r = -r;
		return (int)r;
	}
};

using namespace vl;

TEST_CASE(Test008) {
	Solution sol;
	TEST_ASSERT(sol.myAtoi("    010") == 10);
	TEST_ASSERT(sol.myAtoi("    +020  ") == 20);
	TEST_ASSERT(sol.myAtoi("  -0012a42") == -12);
	TEST_ASSERT(sol.myAtoi("+1") == 1);
	TEST_ASSERT(sol.myAtoi("123456") == 123456);
	TEST_ASSERT(sol.myAtoi("-3456") == -3456);
	TEST_ASSERT(sol.myAtoi("3456.6") == 3456);
	TEST_ASSERT(sol.myAtoi("66666666666") == 0x7fffffff);
	TEST_ASSERT(sol.myAtoi("-2147483648") == (signed int)(0x80000000));
	TEST_ASSERT(sol.myAtoi("2147483648") == 2147483647);
	TEST_ASSERT(sol.myAtoi("-2147483649") == (signed int)(0x80000000));
	TEST_ASSERT(sol.myAtoi("9223372036854775809") == 2147483647);
	std::cout << "0x80000000: " << (signed int)(0x80000000) << std::endl;
	int i = 0x80000000;
	const char * a = "hello world!";
	std::cout << a + 2 << std::endl;
	string b = "hello world!";
	std::cout << b + "123" << std::endl;
	std::cout << "hello world~" + 3 << std::endl;
	std::cout << "i: " << i << std::endl;
}