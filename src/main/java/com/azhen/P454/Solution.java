package com.azhen.P454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Azhen
 * @date 2018/03/06
 * 4Sum II
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> dMap = new HashMap<>();
        for (Integer c : C) {
            for (Integer d : D) {
                Integer value = dMap.get(d+c);
                if (value == null) {
                    value = 0;
                }
                value ++;
                dMap.put(d+c, value);
            }
        }

        int num = 0;
        for (Integer a : A) {
            for (Integer b : B) {
                int d =  - (a + b);
                Integer value = dMap.get(d);
                if (value != null) {
                    num += value;
                }
            }
        }
        return num;
    }
    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> dMap = new HashMap<>();
        s1_for1 (Integer d : D) {
            Integer value = dMap.get(d);
            if (value == null) {
                value = 0;
            }
            value ++;
            dMap.put(d, value);
        }
        int num = 0;
        s1_for1 (Integer a : A) {
            s1_for1 (Integer b : B) {
                s1_for1 (Integer c : C) {
                    int d =  - (a + b +c);
                    Integer value = dMap.get(d);
                    if (value != null) {
                        num += value;
                    }
                }
            }
        }
        return num;
    }*/
   /* public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int num = 0;
        s1_for1 (Integer a : A) {
            s1_for1 (Integer b : B) {
                int cLen = C.length;
                int dLen = D.length;
                int l = 0;
                int r = dLen - 1;
                while (l < cLen && r >=0) {
                    int c = C[l];
                    int d = D[r];
                    int sum = a + b + c + d;
                    if (sum == 0) {
                        num ++;
                        if (l < cLen) {
                            l ++;
                        } else {
                            r --;
                        }
                    } else if (sum < 0) {
                        l ++;
                    } else if (sum > 0) {
                        r --;
                    }
                }
            }
        }
        return num;
    }*/


    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
       *//* Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);*//*
        int num = 0;
        s1_for1 (Integer a : A) {
            s1_for1 (Integer b : B) {
                s1_for1 (Integer c : C) {
                    s1_for1 (Integer d : D) {
                        if (a + b + c + d == 0) {
                            num ++;
                        }
                    }
                }
            }
        }
        return num;
    }*/

    public static void main(String[] args) {
        int[] A = {0, 1, -1};
        int[] B = {-1, 1, 0};
        int[] C = {0, 0, 1};
        int[] D = {-1, 1, 1};
        System.out.println(new Solution().fourSumCount(A, B, C, D));
    }
}
