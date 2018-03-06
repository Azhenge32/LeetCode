package com.azhen.P18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum

 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 * @author Azhen
 * @date 2018/03/06
 */
public class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return ret;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i ++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < len - 2; j ++) {
                if (j - 1 > i && nums[j] == nums[j-1]) continue;
                find(nums, i,j,j + 1, len - 1, target);
            }
        }
        return ret;
    }

    public void find(int[] num, int first, int second, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            int tmp = num[first] + num[second] + num[l] + num[r] - target;
            if (tmp == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(num[first]);
                ans.add(num[second]);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (tmp < 0) {
                l++;
            } else {
                r--;
            }
        }
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        // int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        int[] nums = new int[]{0,0,0,0};
        //int[] nums = new int[]{-2, -1, 0, 0, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> results = solution.fourSum(nums, 0);
        for (List<Integer> list : results) {
            for (Integer item : list) {
                System.out.print(item);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
