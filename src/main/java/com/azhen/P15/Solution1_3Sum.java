package com.azhen.P15;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * @author Azhen
 * @date 2018/01/12
 */
public class Solution1_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        if (!exists(results, list)) {
                            results.add(list);
                        }
                    }
                }
            }
        }
        return results;
    }

    private static boolean exists(List<List<Integer>> lists, List<Integer> plist) {
        if (lists.isEmpty()) {
            return false;
        }
        for (List<Integer> list : lists) {
            int i = 0;
            for (; i < list.size(); i ++) {
                int val = list.get(i);
                int pv = plist.get(i);
                if (val != pv) {
                    break;
                }
            }
            if (i == list.size()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{0, 0, 0, 0};
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = threeSum(nums);
        for (List<Integer> list : results) {
            for (Integer item : list) {
                System.out.print(item);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
