package com.azhen.P35;

import java.util.Arrays;

public class Solution_binarysearch {
    public int searchInsert(int[] nums, int target) {
        int pos =  Arrays.binarySearch(nums, target);
        return pos >= 0 ? pos : -pos - 1;
    }

    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,6};
        Solution_binarysearch solution = new Solution_binarysearch();
        System.out.println(solution.searchInsert(arr, 5));
        System.out.println(solution.searchInsert(arr, 2));
        System.out.println(solution.searchInsert(arr, 7));
        System.out.println(solution.searchInsert(arr, 0));
    }
}
