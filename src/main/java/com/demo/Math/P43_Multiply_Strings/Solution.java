package com.demo.Math.P43_Multiply_Strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String multiply(String a, String b) {
        if (a.equals("0") || b.equals("0"))
            return "0";
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        List<String> strings = new ArrayList<>();
        while (i >= 0) {
            StringBuffer buffer = new StringBuffer();
            for (int k = 0; k < a.length() - 1 - i; k ++) {
                buffer.append("0");
            }

            int aa = a.charAt(i) - '0';
            j = b.length() -1;
            carry = 0;
            while (j >= 0) {
                int sum = carry;
                int bb = b.charAt(j) - '0';
                sum += aa * bb;
                buffer.append(sum % 10);
                carry = sum / 10;
                j --;
            }

            if (carry != 0) buffer.append(carry);
            strings.add(buffer.reverse().toString());
            i --;
        }

        String result = "0";
        for (String str : strings) {
            result = addString(result, str);
        }
        return result;
    }



    public String addString(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("0" ,"9133"));
        System.out.println(solution.multiply("0" ,"3"));
        System.out.println(solution.multiply("2" ,"3"));
        System.out.println(solution.multiply("12" ,"3"));
        System.out.println(solution.multiply("123" ,"456"));
    }
}
