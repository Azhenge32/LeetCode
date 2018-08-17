package com.demo.DivideAndConquer.P215_kth_largest_element_in_an_array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_heap {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length, comparator);
        for (int i : nums) {
            heap.add(i);
        }

        while (k -- > 1) {
            heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        Solution_heap solution = new Solution_heap();
        int[] nums = new  int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums, 4));
    }
}
