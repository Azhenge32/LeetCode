package com.azhen.P717;

/**
 * 717. 1-bit and 2-bit Characters
 *
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 */
class Solution {
    /*private boolean isFirstChar(int bit) {
        return bit == 1;
    }

    private boolean isSecondChar(int[] bits, int idx1, int idx2) {

    }*/
    public boolean isOneBitCharacter(int[] bits) {
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = new int[]{1, 0, 0};
        System.out.println(solution.isOneBitCharacter(bits));
        bits = new int[]{1, 1, 1, 0};
        System.out.println(solution.isOneBitCharacter(bits));
    }
}
