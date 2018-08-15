package com.azhen.P278_firstbadversion;

public class Solution_bs {
    boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        }
        return false;
    }
    public int firstBadVersion(int high) {
        int low = 1;
        while (low <= high) {
            boolean lB = isBadVersion(low);
            if (lB == true) {
                return low;
            }

            if (high == low + 1) {
                if (isBadVersion(high) == true) {
                    return high;
                }
            }
            int mid = low + (high - low) / 2;
            boolean mB = isBadVersion(mid);

            if (mB == false) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return 0;
    }

    public int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_bs().firstBadVersion(2126753390));
    }
}
