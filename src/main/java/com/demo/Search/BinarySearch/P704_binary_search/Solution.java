package com.demo.Search.BinarySearch.P704_binary_search;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int res = binarySearch(nums, 0, nums.length, target);
        return res >=0 ? res : -1;
    }

    public int binarySearch(int[] a, int fromIndex, int toIndex,
                                   int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
