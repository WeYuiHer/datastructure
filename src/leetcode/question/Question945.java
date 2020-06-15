package leetcode.question;

/*
* 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
返回使 A 中的每个值都是唯一的最少操作次数。
示例 1:
输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2:
输入：[3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
	 0 <= A.length <= 40000
	 0 <= A[i] < 40000
* */
public class Question945 {
    public static int minIncrementForUnique(int[] A) {
        int[] B = new int[100000];
        int cnt = 0;
        int x;
        for (int i = 0; i < A.length; i++) {
            x = A[i];
            B[x]++;

        }
        for (int i = 0; i < B.length; ) {
            if (B[i] > 1) {
                int j = i + 1;
                while (B[j] != 0)
                    j++;
                B[j] = 1;
                B[i]--;
                cnt += j - i;
            } else
                i++;
        }
        return cnt;
    }

    public static int minIncrementForUnique2(int[] A) {
        int cnt = 0, ans = 0;
        int[] B = new int[90000];
        for (int x : A)
            B[x]++;
        for (int i = 0; i < 90000; i++) {
            if (B[i] > 1) {
                cnt += B[i] - 1;
                ans -= (B[i] - 1) * i;
            } else if (B[i] == 0 && cnt > 0) {
                cnt--;
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 2, 1};
        int i = minIncrementForUnique(A);
        System.out.println(i);
    }

}
