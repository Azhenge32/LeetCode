package com.azhen.string.P20_ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (Character c : arr) {
            Character peek = null;
            if (!stack.isEmpty()) {
                peek = stack.peek();
            }
            if (same(c, peek)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean same(Character c1, Character c2) {
        if (c2 == null) {
            return false;
        }
        if ('(' == c1 && ')' == c2) {
            return true;
        }
        if ('(' == c2 && ')' == c1) {
            return true;
        }
        if ('{' == c1 && '}' == c2) {
            return true;
        }
        if ('{' == c2 && '}' == c1) {
            return true;
        }
        if ('[' == c1 && ']' == c2) {
            return true;
        }
        if ('[' == c2 && ']' == c1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
    }
}
