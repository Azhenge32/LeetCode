package com.demo.Search.BinarySearch.P374_guess_number_higher_or_lower;

public class Solution {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        if (mid == KEY) {
            return 0;
        } else if (mid < KEY) {
            return -1;
        }
        return 1;
    }

    private static final Integer KEY = 6;
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(10));
    }
}
