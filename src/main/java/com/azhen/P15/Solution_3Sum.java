package com.azhen.P15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Azhen
 * @date 2018/01/12
 */
public class Solution_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // Arrays.stream(nums).forEach(System.out::print);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            int left = i + 1;
            int right = nums.length - 1;
           /* if (left < nums.length && nums[left] == nums[i]) {
                continue;
            }*/
            while (left < right && right >= 0 && left < nums.length) {
                if (right == i) {
                    right --;
                    continue;
                }
                int leftVal = nums[left];
                int rightVal = nums[right];
                int val = nums[i];
                if (val + leftVal + rightVal == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    results.add(list);
                    left ++;
                } else if (val + leftVal + rightVal > 0) {
                    right --;
                } else if (val + leftVal + rightVal < 0) {
                    left ++;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
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
