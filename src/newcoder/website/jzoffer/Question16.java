package newcoder.website.jzoffer;

import java.util.ArrayList;

public class Question16 {
    //找出所有和为S的连续正数序列
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int l = 1, r = 1;
        int s = 1;
        while (r < sum) {
            if (s == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++)
                    list.add(i);
                ans.add(list);
                r++;
                s += r;
            } else if (s < sum) {
                r++;
                s += r;
            } else {
                s -= l;
                l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = FindContinuousSequence(1);
        for (ArrayList<Integer> l : ans)
            System.out.println(l);
    }

}
