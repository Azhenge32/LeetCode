package com.azhen.string.P58_LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int sum = 0;
        boolean preSpace = true;
        for (int i = arr.length - 1; i > -1; i --) {
            char c = arr[i];
            if (preSpace && Character.isSpaceChar(c)) {
                continue  ;
            } else {
                preSpace = false ;
                if (!preSpace && Character.isSpaceChar(c)) {
                    break;
                }
                sum ++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
        System.out.println(new Solution().lengthOfLastWord("a "));
        System.out.println(new Solution().lengthOfLastWord("a"));
        System.out.println(new Solution().lengthOfLastWord("b aa "));
    }
}
