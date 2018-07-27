package com.azhen.string.P67_AddBinary;

public class Solution2 {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = a.toCharArray();
        int maxLength = Math.max(arr1.length, arr2.length);
        char[] result = new char[maxLength + 1];
        char lastResult = '0';
        for (int i = result.length - 1; i > -1; i --) {

        }
        return new String(result);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
