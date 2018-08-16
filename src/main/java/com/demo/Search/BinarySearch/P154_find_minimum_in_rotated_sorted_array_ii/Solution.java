package com.demo.Search.BinarySearch.P154_find_minimum_in_rotated_sorted_array_ii;

import java.util.Arrays;

public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high] || low == high) {
            return nums[low];
        }
        int maxLowPo = nums[high];

        if (nums[0] > maxLowPo) {
            return findMin1(nums);
        }

        Arrays.sort(nums);
        return nums[0];
    }

    public int findMin1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high] || low == high) {
            return nums[low];
        }

        while (low <= high) {
            int maxLowPo = nums[high];
            if (low == high) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (isMin(nums, mid)) {
                return midVal;
            } else if (nums[mid] <= maxLowPo) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[0];
    }

    public int findMin2(int[] nums, int low, int high) {

        if (nums[low] < nums[high] || low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;
        int midVal = nums[mid];
        int lVal = findMin2(nums, low, mid);
        int rVal = findMin2(nums, mid, high);

        return Math.min(midVal, Math.min(lVal, rVal));
    }

    private boolean isMin(int[] nums, int pos) {
        if (pos - 1 >= 0 && nums[pos - 1] > nums[pos]) {
            if (pos + 1 == nums.length || nums[pos] <= nums[pos + 1]) {
                return true;
            }
        }
        return false;
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


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = null;
        nums  = new int[]{1, 3, 5};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{2,2,2,0,1};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{10, 1, 10, 10, 10};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{1, 1};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{3, 1, 3};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{3, 3, 1, 3};
        System.out.println(solution.findMin(nums));
    }
}
