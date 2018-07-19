package com.azhen.string.P557_ReverseStringIII;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int wordBegin = 0;
        for (int i = 0, n = s.length(); i < n; i ++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c)) {
                builder.append(c);
                wordBegin = i + 1;
            } else {
                builder.insert(wordBegin, c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}
