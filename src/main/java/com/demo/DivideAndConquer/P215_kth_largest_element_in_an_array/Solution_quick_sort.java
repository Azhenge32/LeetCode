package com.demo.DivideAndConquer.P215_kth_largest_element_in_an_array;

public class Solution_quick_sort {
    static int index;
    public int findKthLargest(int[] nums, int k) {
        index = nums.length - k;
        quickSort(nums, 0, nums.length-1);
        return nums[index];
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return ;
        }

        // 得到基准元素位置
        int pivotIndex = parttion(arr, startIndex, endIndex);
        if (pivotIndex == index) {
            return ;
        }
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
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
        Solution_quick_sort solution = new Solution_quick_sort();
        int[] nums = null;
        /* nums = new  int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums, 4)); */
        nums = new  int[]{3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 2));
    }
}
