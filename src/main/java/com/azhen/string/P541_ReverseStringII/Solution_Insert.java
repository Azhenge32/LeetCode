package com.azhen.string.P541_ReverseStringII;

public class Solution_Insert {
    public String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, n = (s == null)? 0 : s.length(); i < n; i ++) {
            char c = s.charAt(i);
            if (i % (2 * k) < k) {
                int offset = i - i % (2 * k);
                builder.insert(offset ,c);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_Insert().reverseStr("abcdefg", 2));
    }
}
