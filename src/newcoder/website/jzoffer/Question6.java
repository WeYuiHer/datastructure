package newcoder.website.jzoffer;

public class Question6 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < pre)
                return array[i];
            pre = array[i];
        }
        return pre;
    }
}
