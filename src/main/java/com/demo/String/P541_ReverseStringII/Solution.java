package com.demo.String.P541_ReverseStringII;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for (int i = 0, n = array.length; i < n; i += 2 * k) {
           int j = Math.min(i + k - 1, n - 1);
            reverse(array, i, j);
        }
        return new String(array);
    }

    private void reverse(char[] array, int begin, int end) {
        while (begin < end) {
            char tmp = array[end];
            array[end] = array[begin];
            array[begin] = tmp;
            begin ++;
            end --;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
    }
}
