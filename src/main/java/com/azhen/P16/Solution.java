package com.azhen.P16;

import java.util.Arrays;
import java.util.List;

/**
 * @author Azhen
 * @date 2018/03/06
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        Integer min = null;
        for (int i = 0; i < len - 2; i ++) {
            int find = find(nums, i + 1,len - 1, nums[i], target);
            if (min == null) {
                min = find;
            } else if (Math.abs(find - target) < Math.abs(min - target)) {
                min = find;
            }
        }
        return min;
    }

    private int find(int[] nums, int l, int r, int now, int target) {
        Integer min = null;
        while (l < r) {
            int tmp = now + nums[l] + nums[r];
            if (min == null) {
                min = tmp;
            }
            if (Math.abs(tmp - target) < Math.abs(min - target)) {
                min = tmp;
            }
            if (tmp == target) {
                return tmp;
            } else if(tmp < target) {
                    l ++;
            } else if (tmp > target) {
                    r --;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums,1));
    }
}
