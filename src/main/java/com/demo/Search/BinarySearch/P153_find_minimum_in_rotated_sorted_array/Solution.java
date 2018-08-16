package com.demo.Search.BinarySearch.P153_find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high] || low == high) {
            return nums[low];
        }

        int maxLowPo = nums[high];

        while (low <= high) {
            if (low == high) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (isMin(nums, mid)) {
                return midVal;
            } else if (nums[mid] < maxLowPo) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    private boolean isMin(int[] nums, int pos) {
        if (pos - 1 >= 0 && nums[pos - 1] > nums[pos]) {
            if (pos + 1 == nums.length || nums[pos] <= nums[pos + 1]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = null;
        nums  = new int[]{2, 1};
        System.out.println(solution.findMin(nums));
       /* nums  = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution.findMin(nums));

        nums  = new int[]{1, 3, 5};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{1};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{2,5,6,0,0,1,2};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{3,4,5,1,2};
        System.out.println(solution.findMin(nums));
        nums  = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution.findMin(nums));*/
    }
}
