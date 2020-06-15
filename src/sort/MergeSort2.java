package sort;

import java.util.Arrays;

//统计数组中的逆序对数
public class MergeSort2 {
    int cnt = 0;

    public void mergeSort(int[] num, int l, int r) {
        if (l == r) return;
        int m = l + (r - l) / 2;
        mergeSort(num, l, m);
        mergeSort(num, m + 1, r);
        merge(num, l, m, r);
    }

    public void merge(int[] num, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (num[i] <= num[j])
                temp[k++] = num[i++];
            else {
                temp[k++] = num[j++];
                cnt += m - i + 1;
            }
        }
        while (i <= m)
            temp[k++] = num[i++];
        while (j <= r)
            temp[k++] = num[j++];
        for (i = 0; i < k; i++)
            num[l + i] = temp[i];
    }

    public static void main(String[] args) {
        MergeSort2 sort = new MergeSort2();
        int[] num = {4, 1, 5, 2, 6, 3, 7, 9, 8, 2, 1, 10};
        sort.mergeSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
        System.out.println(sort.cnt);
    }


}
