package com.azhen.P89;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Azhen
 * @date 2018/03/28
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 1) {
            result.add(0);
            return result;
        }
       List<String> grayCodeArr = grayCodeStr(n);
       for (String gray: grayCodeArr) {
           int i = Integer.valueOf(gray, 2);
           result.add(i);
       }
       return result;
    };

    public List<String> grayCodeStr(int n) {
        if (n == 1) {
            List<String> n1 = new ArrayList<>();
            n1.add("0");
            n1.add("1");
            return n1;
        }

        List<String> n2 = grayCodeStr(n - 1);
        List<String> result = new ArrayList<>();
        for (String str : n2) {
            StringBuilder sb = new StringBuilder("0");
            sb.append(str);
            result.add(sb.toString());
        }
        Collections.reverse(n2);
        for (String str : n2) {
            StringBuilder sb = new StringBuilder("1");
            sb.append(str);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.grayCode(0);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
