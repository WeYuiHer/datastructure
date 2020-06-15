package newcoder.website.jzoffer;

import java.util.Arrays;

public class Question26 {
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        arr1[0] = A[0];
        arr2[len - 1] = A[len - 1];
        for (int i = 1; i < len; i++) {
            arr1[i] = A[i] * arr1[i - 1];
            arr2[len - i - 1] = A[len - i - 1] * arr2[len - i];
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));

        int[] B = new int[len];
        if (len <= 1)
            return B;
        B[0] = arr2[1];
        B[len - 1] = arr1[len - 2];
        for (int i = 1; i < len - 1; i++) {
            B[i] = arr1[i - 1] * arr2[i + 1];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1};
        int[] B = multiply(A);
        System.out.println(Arrays.toString(B));
    }

}
