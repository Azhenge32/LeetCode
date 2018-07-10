package com.demo.TwoPointer.P344_ReverseString;

public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        int n = arr.length - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = arr[j];
            char ck = arr[k];
            arr[j] = ck;
            arr[k] = cj;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("hello"));
        System.out.println(solution.reverseString("hell"));
        System.out.println(solution.reverseString("我爱中国"));
        System.out.println(solution.reverseString("我是谁"));
    }
}
