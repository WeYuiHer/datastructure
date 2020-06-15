package leetcode.question3;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */
public class Question1095 {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        //找到峰顶
        int l = 0, r = mountainArr.length() - 1;
        int peek = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;  //由题意知 0 < m < mountainArr.length() - 1
            int top = mountainArr.get(m);
            if (top > mountainArr.get(m - 1) && top > mountainArr.get(m + 1)) {
                peek = m;
                break;
            } else if (top > mountainArr.get(m - 1)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int index = binarySearch(target, mountainArr, 0, peek, true);
        if (index != -1)
            return index;
        else
            return binarySearch(target, mountainArr, peek + 1, mountainArr.length() - 1, false);
    }

    //正序的二分查找
    public int binarySearch(int target, MountainArray mountainArr, int l, int r, boolean f) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int x = mountainArr.get(m);
            if (x == target) {
                return m;
            } else if (x > target) {
                if (f)
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (f)
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        return -1;
    }


}

interface MountainArray {
    public int get(int index);

    public int length();

}