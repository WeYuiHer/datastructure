package newcoder.website.jzoffer;

/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * */
public class Question14 {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] seq, int st, int end) {
        if (st == end)
            return true;
        int m = st;
        while (m < end && seq[m++] < seq[end]) ;
        int k = m;
        while (m < end && seq[m++] > seq[end]) ;
        if (m != end)
            return false;
        return verify(seq, st, k - 1) && verify(seq, k + 1, end);
    }

    //非递归解法
    public boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int n = sequence.length;
        int i = 0;
        while (n-- > 0) {
            while (i < n && sequence[i++] < sequence[n]) ;
            while (i < n && sequence[i++] > sequence[n]) ;
            if (i != n) return false;
            i = 0;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] seq = {1, 2, 3, 4, 5};
        boolean b = VerifySquenceOfBST(seq);
        System.out.println(b);
    }

}
