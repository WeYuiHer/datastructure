package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Question945 {
    public static int minIncrementForUnique(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int n = A.length;
        ArrayList<Integer> repid = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int pre = A[0];
        int cnt = 0;
        int i = 0, j = 0;
        for (i = 1; i < n; i++) {
            if (pre == A[i]) {
                repid.add(A[i]);
            } else if (A[i] - pre > 1 && repid.size() > 0) {
                for (j = pre + 1; j < A[i] && temp.size() < repid.size(); j++)
                    temp.add(j);
            }
            pre = A[i];
        }
        i = 0;
        j = 0;
        System.out.println(repid);
        System.out.println(temp);
        while (i < repid.size() && j < temp.size()) {
            cnt += temp.get(j) - repid.get(i);
            i++;
            j++;
        }

        int x = A[n - 1] + 1;

        while (i < repid.size()) {
            cnt += x - repid.get(i);
            x++;
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {14, 4, 5, 14, 13, 14, 10, 17, 2, 12, 2, 14, 7, 13, 14, 13, 4, 16, 4, 10};
        int i = minIncrementForUnique(arr);
        System.out.println(i);
    }
}
