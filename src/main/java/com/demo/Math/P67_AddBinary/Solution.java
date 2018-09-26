package com.demo.Math.P67_AddBinary;

public class Solution {

    public String addBinary(String a, String b) {
        int ia = Integer.parseInt(a, 2);
        int ib = Integer.parseInt(b, 2);
        return Integer.toBinaryString(ia + ib);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
