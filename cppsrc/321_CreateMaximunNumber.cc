#include "Vlpp.h"

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:

    struct Node {
        Node(int d,int t): data(d), type(t)  {}
        Node() {}
        int data;
        int type;
    };   


    class MaxPQ {
    private:
        vector<Node> pq;
        vector<int> nums;
        size_t length;
    public:
        MaxPQ(int k): length(k) {
        }
 
        void printq() {
            char cs[100];
            for (auto node : pq) {
                snprintf(cs , sizeof(cs)-1, "%d ", node.data);
                cout << cs;
            }
            cout << endl;
            for (auto node : pq) {
                snprintf(cs , sizeof(cs)-1, "%d ", node.type);
                cout << cs;
            }
            cout<<endl;
        }

        void insert(Node& node) {
            auto iter = pq.end()-1;
            if (pq.empty()) {
                pq.push_back(node);
                cout << "push back " << node.data << ", type " << node.type <<endl;
                printq(); 
            } else if (node.type == pq.back().type) {
                pq.push_back(node);
                cout << "push back " << node.data << ", type " << node.type <<endl;
                printq(); 
            } else {
                while (node.type != iter->type && node.data > iter->data && iter!= pq.begin())
                    iter--;
                
                if (iter == pq.begin() && node.type != iter->type && node.data > iter->data)
                    pq.insert(iter, node);
                else 
                    pq.insert(iter+1, node);
                cout << "insert " << node.data << ", type " << node.type <<endl;
                printq(); 
            }
            if (pq.size() > length) {
                int erase_type = 0;
                auto pos1 = iter;
                auto pos2 = iter;
                for (iter=pq.begin(); iter!=pq.end() && (iter+1) != pq.end(); iter++) {
                    if (iter->data < (iter+1)->data) {
                        erase_type = iter->type;
                        pos1 = iter;
                        cout << "erase " << iter->data << ", type " << iter->type <<endl;
                        pq.erase(iter);
                        printq(); 
                        break;
                    } 
                }
                if (erase_type == 0) {
                    pq.pop_back();
                }
                if (pos1->type == erase_type && pos1 != pq.begin()) {
                    sort(pos1, erase_type);
                }

            }
        }
        void sort(vector<Node>::iterator pos1, int erase_type) {
            auto iter = pos1;
            iter--;
            while (erase_type != iter->type && pos1->data > iter->data && iter!= pq.begin())
                iter--;
         
            if (iter!= pq.begin() || (iter==pq.begin() && iter->type == erase_type)) 
                iter++;
            if (pos1->type != iter->type && pos1->data > iter->data) {
                bool needsort = pos1+1 != pq.end() && (pos1+1)->type == pos1->type;
                swim(iter, pos1);
                cout<< "swim" << endl;
                printq(); 
                if (needsort) {
                    sort(pos1+1, erase_type);
                }
            }
                    
        }

        void swim(vector<Node>::iterator p1, vector<Node>::iterator p2) {
            Node node = *p2;
            pq.erase(p2);
            pq.insert(p1, node);
        }

        vector<int>& getNum() {
            for (auto node : pq) {
                nums.push_back(node.data);
            }
            return nums;
        }

    };

    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        MaxPQ maxPq(k);
        
        while(nums1.size()>0 || nums2.size()>0) {
            if (nums1.size()>0) {
                Node node(nums1[0], 1);
                maxPq.insert(node);
                nums1.erase(nums1.begin());
            } 
            if (nums2.size()>0) {
                Node node(nums2[0], 2);
                maxPq.insert(node);
                nums2.erase(nums2.begin());
            }
        }
        return maxPq.getNum();
    }
    
};

TEST_CASE(Test321) {
    //Solution s;
//    vector<int> nums1 = {3, 4, 6, 5};
//    vector<int> nums2 = {9, 1, 2, 5, 8, 3};
    /*vector<int> nums1 = {1,7,5};
    vector<int> nums2 = {8,6,9};
    auto pq = s.maxNumber(nums1, nums2, 3);
    cout << "pq.size = " << pq.size() << endl;
    for(int i=0; i<pq.size(); i++) {
        cout << "pq["<< i <<"] = " <<pq[i] << endl;
    }*/
}
