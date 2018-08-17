package com.demo.DivideAndConquer.P215_kth_largest_element_in_an_array;

public class Solution_quick_sort2 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        return quickSelect(nums, 0, nums.length-1, k);
    }

    public static int quickSelect(int[] arr, int startIndex, int endIndex, int k) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }

        // 得到基准元素位置
        int pivotIndex = parttion(arr, startIndex, endIndex);

        if (pivotIndex - startIndex + 1 > k) {
            return quickSelect(arr, startIndex, pivotIndex - 1, k);
        } else if (pivotIndex - startIndex + 1 == k) {
            return arr[pivotIndex];
        } else {
            return quickSelect(arr, pivotIndex + 1, endIndex, k - pivotIndex + startIndex - 1);
        }
    }

    private static int parttion(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right --;
            }
            while (left < right && arr[left] <= pivot) {
                left ++;
            }

            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }

    public static void main(String[] args) {
        Solution_quick_sort2 solution = new Solution_quick_sort2();
        int[] nums = null;
        /* nums = new  int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums, 4)); */
        nums = new  int[]{3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 2));
    }
}
