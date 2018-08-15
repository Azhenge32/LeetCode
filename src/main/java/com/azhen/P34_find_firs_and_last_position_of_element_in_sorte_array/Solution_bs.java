package com.azhen.P34_find_firs_and_last_position_of_element_in_sorte_array;

public class Solution_bs {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = findFirst(nums, target);
        if (start < 0) {
            return res;
        }
        int end = findLast(nums, target);
        res[0] = start;
        res[1] = end;
        return res;
    }

    public int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return start < nums.length && nums[start] == target ? start: -1;
    }

    public int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (nums[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return start < nums.length && nums[start] == target ? start: -1;
    }

    public static void main(String[] args) {
        Solution_bs solution = new Solution_bs();
        //int[] res = solution.searchRange(new int[]{5,7,7,8,8,8,8,10}, 8);
        //System.out.println(res[0] + " : " + res[1]);
        //int[] res = solution.searchRange(new int[]{5,7,7,8,8,10}, 6);
        //System.out.println(res[0] + " : " + res[1]);
        // int[] res = solution.searchRange(new int[]{2, 2}, 3);
        // System.out.println(res[0] + " : " + res[1]);
        int[] res = solution.searchRange(new int[]{2, 2}, 2);
        System.out.println(res[0] + " : " + res[1]);
    }
}
