package com.demo.Math.P67_AddBinary;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int maxLength = Math.max(arr1.length, arr2.length);
        char[] result = new char[maxLength + 1];
        char lastResult = '0';
        StringBuffer buffer = new StringBuffer(maxLength);
        for (int i = result.length - 1; i > -1; i --) {
            int j = result.length - i;
            char a1 = '0';
            char a2 = '0';
            if (arr1.length - j > -1) {
                a1 = arr1[arr1.length - j];
            }
            if (arr2.length - j > -1) {
                a2 = arr2[arr2.length - j];
            }

            List<Character> list = new ArrayList<>(3);
            list.add(lastResult);
            list.add(a1);
            list.add(a2);

            int count = count(list);
            char res = '0';
            lastResult = '0';
            if (count % 2 == 1) {
                res = '1';
            }
            if (count > 1) {
                lastResult = '1';
            }

            if (lastResult == '0' && res == '0' && i == 0) {
                break;
            }
            buffer.insert(0, res);
        }
        return buffer.toString();
    }

    private int count(List<Character> list) {
        int count = 0;
        for (char c : list) {
            if (c == '1') {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.addBinary("0", "0"));  // 10
        System.out.println(solution.addBinary("1", "1"));  // 10
        System.out.println(solution.addBinary("11", "1"));  // 100
        System.out.println(solution.addBinary("1010", "1011")); // 10101
        System.out.println(solution.addBinary("111111", "1")); // 10101
        System.out.println(solution.addBinary("100", "110010")); // 110110
    }
}
