#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> pq(nums2);
        cout << "pq.size = " << pq.size() << endl;
        for(int i=0; i<pq.size(); i++) {
            cout << "pq["<< i <<"] = " <<pq[i] << endl;
        }
        while(false) {
            
        }
        return pq;
    }
};

int main() {
    Solution s;
    vector<int> nums1 = {3, 4, 6, 5};
    vector<int> nums2 = {9, 1, 2, 5, 8, 3};
    s.maxNumber(nums1, nums2, 5);
}
