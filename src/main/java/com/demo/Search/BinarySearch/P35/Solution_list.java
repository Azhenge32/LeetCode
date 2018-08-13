package com.demo.Search.BinarySearch.P35;

public class Solution_list {
    public int searchInsert(int[] nums, int target) {
        int length = (nums == null) ? 0 : nums.length;
        for (int i = 0; i < length; i ++) {
            int num = nums[i];
            if (num >= target) {
                return i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,6};
        Solution_list solution = new Solution_list();
        System.out.println(solution.searchInsert(arr, 5));
        System.out.println(solution.searchInsert(arr, 2));
        System.out.println(solution.searchInsert(arr, 7));
        System.out.println(solution.searchInsert(arr, 0));
    }
}
