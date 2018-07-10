package com.azhen.P35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int val = (nums[left] + nums[right]) / 2;
            if (val < target) {
                left = (left + right) / 2;
            } else {
                right = (left + right) / 2;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[left] > target) {
            if (left == 0) {
                return 0;
            } else {
                return left - 1;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[right] < target) {
            return right + 1;
        }

        if (nums[left] < target && nums[right] > target && left + 1 == right) {
            return right;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(arr, 5));
        System.out.println(solution.searchInsert(arr, 2));
        System.out.println(solution.searchInsert(arr, 7));
        System.out.println(solution.searchInsert(arr, 0));
        /*int[] arr = new int[] {1};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(arr, 2));*/
    }
}
