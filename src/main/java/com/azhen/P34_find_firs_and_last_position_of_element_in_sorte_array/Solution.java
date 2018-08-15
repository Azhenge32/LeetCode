package com.azhen.P34_find_firs_and_last_position_of_element_in_sorte_array;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        if (pos < 0) {
            return new int[]{-1, -1};
        }
        int low = pos;
        int high = pos;
        int[] res = new int[2];
        while (low >=0 && nums[low] == target) {
            res[0] = low;
            low --;
        }
        while (high < nums.length && nums[high] == target) {
            res[1] = high;
            high ++;
        }

        return res;
    }

    private int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        int[] res = new Solution().searchRange(nums, 1);
        System.out.println(res[0] + " ： " + res[1]);
    }
}
