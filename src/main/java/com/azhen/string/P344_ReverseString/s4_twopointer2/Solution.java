package com.azhen.string.P344_ReverseString.s4_twopointer2;

public class Solution {
    public String reverseString(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = bytes.length - 1;
        while (i < j) {
            bytes[i] = (byte)(bytes[i] ^ bytes[j]);
            bytes[j] = (byte)(bytes[i] ^ bytes[j]);
            bytes[i] = (byte)(bytes[i] ^ bytes[j]);
            i ++;
            j --;
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("hello"));
        System.out.println(solution.reverseString("hell"));
        System.out.println(solution.reverseString("我爱中国"));
        System.out.println(solution.reverseString("我是谁"));
    }
}
