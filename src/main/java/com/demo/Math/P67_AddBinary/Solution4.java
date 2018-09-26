package com.demo.Math.P67_AddBinary;

public class Solution4 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        //System.out.println(solution.addBinary("0", "0"));  // 10
        //System.out.println(solution.addBinary("1", "1"));  // 10
        System.out.println(solution.addBinary("11", "1"));  // 100
        System.out.println(solution.addBinary("1010", "1011")); // 10101
        System.out.println(solution.addBinary("111111", "1")); // 10101
        System.out.println(solution.addBinary("100", "110010")); // 110110
    }
}
