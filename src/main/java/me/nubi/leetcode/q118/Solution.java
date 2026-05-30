package me.nubi.leetcode.q118;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (numRows == 1) {
            list.add(1);
            resultList.add(list);
            return resultList;
        }
        resultList = generate(numRows - 1);
        List<Integer> last = resultList.get(resultList.size()-1);
        list.add(last.get(0));
        for (int i = 0; i < last.size() - 1; i++) {
            list.add(last.get(i) + last.get(i + 1));
        }
        list.add(last.get(last.size() - 1));
        resultList.add(list);
        return resultList;
    }
}