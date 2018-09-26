package com.demo.Math.P67_AddBinary;

public class Solution3 {
    public String addBinary(String a, String b) {
        char[] arr1 = b.toCharArray();
        char[] arr2 = a.toCharArray();
        if (a.length() >  b.length()) {
            arr1 = a.toCharArray();
            arr2 = b.toCharArray();
        }

        char last = '0';
        char[] results = new char[arr1.length + 1];
        for (int i = results.length - 1; i > -1; i --) {
            char c1 = '0';
            char c2 = '0';
            int j = results.length  - i;
            if (arr1.length - j > -1) {
                c1 = arr1[arr1.length - j];
            }

            if (arr2.length - j > -1) {
                c2 = arr2[arr2.length - j];
            }

            int count = 0;
            if (last == '1') {
                count ++;
            }
            if (c1 == '1') {
                count ++;
            }
            if (c2 == '1') {
                count ++;
            }

            last = '0';
            char res = '0';
            if (count % 2 == 1) {
                res = '1';
            }

            if (count > 1) {
                last = '1';
            }
            results[i] = res;
        }

        if (results[0] == '0') {
            return String.valueOf(results, 1, results.length - 1);
        }
        return String.valueOf(results);
    }


    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        //System.out.println(solution.addBinary("0", "0"));  // 10
        //System.out.println(solution.addBinary("1", "1"));  // 10
        System.out.println(solution.addBinary("11", "1"));  // 100
        System.out.println(solution.addBinary("1010", "1011")); // 10101
        System.out.println(solution.addBinary("111111", "1")); // 10101
        System.out.println(solution.addBinary("100", "110010")); // 110110
    }
}
