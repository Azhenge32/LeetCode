package com.azhen.P717OA;

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
        if (bits == null) {
            return false;
        }
        if (bits.length == 1) {
            return bits[bits.length - 1] == 0;
        }
        if (bits.length == 2) {
            return bits[0] == 0;
        }
        if (bits[bits.length - 2] != 1) {
            return true;
        }
        return !judge(bits, 0, bits.length - 3);
    }

    public boolean judge (int[] bits, int start, int end) {
        if (start == end && bits[start] == 0) {
            return true;
        }
        if (start + 1 == end && bits[start] == 1) {
            return true;
        }
        boolean flag = false;
         if (!flag && bits[start] == 0) {
            flag = judge(bits, start + 1, end);
        }
        if (!flag && start + 1 <= end && bits[start] == 1) {
            flag = judge(bits, start + 2, end);
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = new int[]{1, 0, 0};
        System.out.println(solution.isOneBitCharacter(bits));
        bits = new int[]{1, 1, 1, 0};
        System.out.println(solution.isOneBitCharacter(bits));
        bits = new int[]{0};
        System.out.println(solution.isOneBitCharacter(bits));
        bits = new int[]{0, 0};
        System.out.println(solution.isOneBitCharacter(bits));
        bits = new int[]{1, 0};
        System.out.println(solution.isOneBitCharacter(bits));
    }
}
