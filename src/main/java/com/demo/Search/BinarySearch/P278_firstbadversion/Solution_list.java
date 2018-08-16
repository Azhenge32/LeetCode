package com.demo.Search.BinarySearch.P278_firstbadversion;

public class Solution_list {
    boolean isBadVersion(int n) {
        return false;
    }
    public int firstBadVersion(int n) {
        int i = 1;
        while (i < n) {
            boolean res = isBadVersion(i);
            if (res == true) {
                return i;
            }
            i ++;
        }
        return 0;
    }
}
