#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:

    struct Node {
        Node(d, t): data(d), type(t)  {}
        int data;
        int type;
    };   


    class MaxPQ {
    private:
        vector<Node> pq;
    public:
        MaxPQ(int k): pq(k) {}
        void insert(Node& node) {
            for (int i=0; i< pq.size(); i++) {
                if (type == 1) {
                } else {
                }
            }
        }

        int delMax() {
            return 0;
        }

        void swap(int i, int j) {
        }



    }

    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        pq.clear(); 

        cout << "pq.size = " << pq.size() << endl;
        for(int i=0; i<pq.size(); i++) {
            cout << "pq["<< i <<"] = " <<pq[i] << endl;
        }
        int i1=0, i2=0;
        while(true) {
            if (nums1.size()>0) {
                Node node(nums1[0], 1);
                insert(node);
            } 
            if (nums2.size()>0) {
                Node node(nums2[0], 2);
                insert(node);
            }
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
