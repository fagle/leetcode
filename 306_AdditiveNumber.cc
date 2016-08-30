#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
    bool isAdditiveNumber(string num) {
        int len = num.length();
        if(len < 3)
            return false;
        for (int i=1; i<=len/3; i++) {
            for (int j=1; j<=(len-i)/2; j++) {
                string s1 = num.substr(i, j);
                if (s1[0]=='0' && s1.length()!=1)
                    continue;
                string s = add((string)num.substr(0, i), s1);
                if (num.find(s, i+j) != i+j)
                    continue;
                string s2 = s;
                bool additive = true;
                for (int k=i+j+s.length(); k < len; k=k+s.length()) {
                    if (s2[0] == '0' && s2.length()!=1) {
                        additive = false;
                        break;
                    }
                    s = add(s1,s2);
                    if (num.find(s, k) !=k) {
                        additive = false;
                        break;
                    }
                    s1=s2;
                    s2=s;
                    additive = true;
                }
                if (additive)
                    return true;
            }
        }
        return false;
    }

    bool canAdd(string& s1, string& s2, string& s3) {
        if (s3 == add(s1, s2))
            return true;
        else
            return false;
    }
    string add(const string& s1,const string& s2) {
        string s;
        const string * short_str=&s1, *long_str=&s2;
        int len1=s1.length();
        int len2=s2.length();
        int carry=0;
        if (len1>len2) {
            short_str=&s2;
            long_str=&s1;
        }
        int diff=long_str->length()-short_str->length();
        for(int i=short_str->length()-1; i>=0; i--) {
            char sum = ((*short_str)[i]-'0') + ((*long_str)[diff+i]-'0') + '0' + carry;
            if (sum > '9') {
                carry=1;
                sum = sum - 10;
            }
            else
                carry=0;
            s.insert(0, 1, sum);

        }
        for(int i=long_str->length() - short_str->length() - 1; i>=0; i--) {
            char sum = (*long_str)[i]+carry;
            if (sum > '9') {
                carry=1;
                sum -= 10;
            }
            else
                carry=0;
            s.insert(0, 1, sum);
        }
        if (carry)
            s.insert(0, 1, '1');
        return s;
    }
};

int main() {
    Solution s;
    string s1("123");//true
    string s2("120122436");//false
    cout << s.isAdditiveNumber(s2) << endl;
}
