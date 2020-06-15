package leetcode.contest3;

import java.util.ArrayList;
import java.util.List;

/*
* 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
巨无霸汉堡：4 片番茄和 1 片奶酪
小皇堡：2 片番茄和 1 片奶酪
请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
* */
public class Question2 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int x = (tomatoSlices - 2 * cheeseSlices) / 2;
        int y = (4 * cheeseSlices - tomatoSlices) / 2;
        int m = x * 4 + y * 2;
        int n = x + y;
        if (x >= 0 && y >= 0 && m == tomatoSlices && n == cheeseSlices) {
            list.add(x);
            list.add(y);
        }
        return list;
    }

}
