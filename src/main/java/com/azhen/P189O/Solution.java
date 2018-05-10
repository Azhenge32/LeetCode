package com.azhen.P189O;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null) {
            return ;
        }

        k %= nums.length;
        if (k == 0) {
            return ;
        }

        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
           int j = (i + k) % nums.length;
            nums2[j] = nums[i];
        }

        for (int i = 0; i < nums2.length; i ++) {
            nums[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] num = new int[]{1,2,3,4,5,6,7};
        solution.rotate(num, 3);*/
        int[] num = new int[]{1,2};
        solution.rotate(num, 1);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
