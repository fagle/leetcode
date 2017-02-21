package me.nubi.leetcode;

/**
 * Created by Fagle on 2017/2/19 0019.
 */
public class Problem321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] s = new int[k];
        if (k == nums1.length + nums2.length) {
            s = merge(nums1, nums2);
            return s;
        }
        else {
            for (int i = 1; i < k; i++) {
                if (i > nums1.length || k - i > nums2.length)
                    continue;
                int[] t = merge(maxNumber(nums1, 0, i), maxNumber(nums2, 0, k - i));
                if (compare(s, t) < 0)
                    s = t;
            }
        }
        return s;
    }

    private int[] merge(int [] a, int [] b) {
        int n = a.length + b.length;
        int[] s = new int[n];

        for (int j=0, i=0, k=0; i<a.length || j<b.length;) {
            if (i == a.length) {
                s[k++] = b[j++];
                continue;
            }
            else if (j == b.length) {
                s[k++] = a[i++];
                continue;
            }

            if (a[i] == b[j])
                if (i+1 == a.length)
                    s[k++] = b[j++];
                else if(j+1 == b.length)
                    s[k++] = a[i++];
                else
                    for (int x=i+1, y=j+1; ; x++,y++) {
                        if (x == a.length){
                            s[k++] = b[j++];
                            break;
                        }
                        else if(y == b.length) {
                            s[k++] = a[i++];
                            break;
                        } else {
                            if (x>=a.length || y>=b.length)
                                System.out.println();
                            if (a[x] > b[y]) {
                                s[k++] = a[i++];
                                break;
                            } else if (a[x] < b[y]) {
                                s[k++] = b[j++];
                                break;
                            }
                        }
                    }
            else if (a[i] > b[j]) {
                s[k++] = a[i++];
            }
            else {
                s[k++] = b[j++];
            }
        }

        return s;
    }

    private int[] maxNumber(int[] nums, int start, int k) {
        int[] result = new int[k];
        int minPos = start;
        int min = nums[start];
        int maxPos = start;
        int max = nums[start];
        int len = nums.length - start;
        for (int i=start + 1; i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }
        if (k==1) {
            result[0] = max;
            return result;
        }
        int llen = maxPos - start;
        int rlen = len - (maxPos - start);
        int[] right = new int[rlen];
        System.arraycopy(nums, maxPos, right, 0, rlen);
        if (rlen == k)
            return right;
        if (rlen > k) {
            result[0] = max;
            right = maxNumber(right, 1, k - 1);
            System.arraycopy(right, 0, result, 1, k-1);
        } else {
            int[] left = new int[llen];
            System.arraycopy(nums, start, left, 0, llen);
            if (left.length == 0)
                System.out.println();
            left = maxNumber(left, 0, k - rlen);
            System.arraycopy(left, 0, result, 0, left.length);
            System.arraycopy(right, 0, result, left.length, rlen);
        }
        return result;
    }

    private int compare(int [] a, int [] b) {
        for (int i=0; i < a.length; i++) {
            if (a[i] < b[i])
                return -1;
            else if(a[i] > b[i])
                return 1;
        }
        return 0;
    }
}
