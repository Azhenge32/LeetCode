package com.azhen.P189O;

public class Solution1 {
    public int[] rotate(int[] nums, int k) {
        if (k == 0 || nums == null) {
            return null;
        }

        k %= nums.length;
        if (k == 0) {
            return nums;
        }
        Integer tmp = null;
        int currp = 0;
       /*for (int i = 0; i < nums.length; i ++) {
           int nextp = nextPos(currp, k, nums.length);
           tmp = nums[nextp];
           nums[nextp] = nums[currp];
           currp = nextp;
       }*/
        return nums;
    }

    private int nextPos(int i, int shift, int len) {
        return (i - shift) % len;
    }

    private int prePos(int i, int shift, int len) {
        return (i + shift) % len;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] num = new int[]{1,2,3,4,5,6,7};
        num = solution.rotate(num, 3);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
