#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    int lengthLongestPath(string input) {
        if (input.empty())
            return 0;
        vector<int> lens;
        int level=0, curlen=0, maxlen=0;
        bool bFile=false;
        lens.push_back(0);
        for(int i=0; i<input.length(); i++){
            switch(input[i]) {
                case '\n':
                    if(bFile) {
                        curlen=curlen+level;
                        if (curlen>maxlen)
                            maxlen=curlen;
		            }
                    else
                        lens[level] = curlen;
                    curlen=0;
                    level=0;
                    bFile=false;
                    break;
                case '.':
                    bFile=true;
		            curlen++;
                    break;
                case '\t':
                    curlen=lens[level];
                    level++;
		            if(level>lens.size() - 1)
                        lens.push_back(0);
                    break;
                default:
                    curlen++;
            }
	        
        }
        if(bFile) {
                curlen=curlen+level;
                if (curlen>maxlen)
                    maxlen=curlen;
            }
        return maxlen;
    }
};

int main() {
    Solution s;
    std::cout << s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext") << endl;
}
