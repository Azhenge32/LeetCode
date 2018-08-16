package com.demo.Search.BinarySearch.P81_search_in_rotated_sorted_array_ii;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return search2(nums, 0, nums.length - 1, target);
    }

    public boolean search2(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        }
        if (low == high) {
            if (nums[low] == target) {
                return true;
            }
            return false;
        }

        int pos = binarySearch(nums, low, high, target);
        if (pos > -1) {
            return true;
        } else {
            int mid = low + (high - low) / 2;
            boolean posl = search2(nums, low, mid - 1, target);
            if (posl == true) {
                return true;
            }
            boolean posr = search2(nums, mid + 1, high, target);
            if (posr == true) {
                return true;
            }
        }

        return false;
    }

    public int binarySearch(int[] a, int fromIndex, int toIndex,
                            int key) {
        int low = fromIndex;
        int high = toIndex;

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
       nums  = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 4));
        System.out.println(solution.search(nums, 5));
        System.out.println(solution.search(nums, 6));
        System.out.println(solution.search(nums, 7));
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 1));
        System.out.println(solution.search(nums, 2));

        nums  = new int[]{1, 3, 5};
        System.out.println(solution.search(nums, 0));
        nums  = new int[]{1};
        System.out.println(solution.search(nums, 1));
        nums  = new int[]{2,5,6,0,0,1,2};
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
    }
}
