package com.azhen.P89;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Azhen
 * @date 2018/03/28
 */
public class Solution_Bit {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            System.out.println(Integer.toBinaryString(i));
            System.out.println(Integer.toBinaryString(i >> 1));
            System.out.println(Integer.toBinaryString(i ^ i >> 1));
            result.add(i ^ i>>1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_Bit solution = new Solution_Bit();
        List<Integer> integers = solution.grayCode(2);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
