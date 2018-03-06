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
        int min = nums[len - 1];
        for (int i = 0; i < len - 2; i ++) {
            int find = find(nums, i + 1,len - 1, nums[i], target);
            if (min > find) {
                min = find;
            }
        }
        return min;
    }

    private int find(int[] nums, int l, int r, int now, int target) {
        Integer min = null;
        while (l < r) {
            int tmp = now + nums[l] + nums[r] + target;
            if (min == null) {
                min = Math.abs(tmp);
            }
            if (Math.abs(tmp) < min) {
                min = Math.abs(tmp);
            }
            if (tmp == 0) {
                return 0;
            } else if(tmp < 0) {
               // while (l < r && nums[l] == nums[l + 1]) {
                    l ++;
                //}
            } else if (tmp > 0) {
                //while (l < r && nums[r] == nums[r - 1]) {
                    r --;
                //}
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
